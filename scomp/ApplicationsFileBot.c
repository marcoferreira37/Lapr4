#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>
#include <dirent.h>
#include <errno.h> // Include errno for error handling

#define IN_PATH "Email-Bot-Output" // Input directory
#define OUT_PATH "Shared_Folder"   // Output directory (no leading / for relative path)

void copyFiles() {
    DIR *dir;
    struct dirent *entry;

    // Open the input directory
    dir = opendir(IN_PATH);
    if (dir == NULL) {
        perror("opendir");
        exit(EXIT_FAILURE);
    }

    // Iterate through each entry in the input directory
    while ((entry = readdir(dir)) != NULL) {
        if (strcmp(entry->d_name, ".") == 0 || strcmp(entry->d_name, "..") == 0) {
            continue; // Skip current directory and parent directory entries
        }

        if (strstr(entry->d_name, "candidate_data") != NULL) {
            char src_path[1024];
            char dest_dir[1024];
            char subfolder_path[1024];

            // Generate source file path
            snprintf(src_path, sizeof(src_path), "%s/%s", IN_PATH, entry->d_name);

            // Open the source file
            FILE *file = fopen(src_path, "r");
            if (file == NULL) {
                perror("fopen");
                continue;
            }

            // Read candidate name from the file
            char candidate_name[1024];
            if (fgets(candidate_name, sizeof(candidate_name), file) == NULL) {
                fclose(file);
                continue;
            }
            candidate_name[strcspn(candidate_name, "\n")] = '\0';

            // Generate destination directory path
            snprintf(dest_dir, sizeof(dest_dir), "%s/%s", OUT_PATH, candidate_name);
            // Create destination directory if it doesn't exist
            if (mkdir(dest_dir, 0777) == -1 && errno != EEXIST) {
                perror("mkdir");
                fclose(file);
                continue;
            }

            // Create subfolder path
            snprintf(subfolder_path, sizeof(subfolder_path), "%s/%s", dest_dir, entry->d_name);
            // Move the file to the subfolder
            if (rename(src_path, subfolder_path) != 0) {
                perror("rename");
            }

            fclose(file);
        }
    }

    closedir(dir);
}

// Signal handler for directory change
void handle_directory_change(int signo, siginfo_t *info, void *context){
    printf("The directory was changed!\n");

    // Create a new child process
    pid_t pid;
    pid = fork();
    if (pid == -1) {
        perror("Error creating the child process");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        copyFiles(); // Call the function to copy files
        exit(EXIT_SUCCESS);
    }
}

// Signal handler for SIGINT
void handle_sigint(int signo) {
    printf("\nReceived SIGINT signal. Terminating the program...\n");

    // Kill all child processes
    kill(0, SIGTERM);

    // Wait for child processes to end
    while (wait(NULL) > 0);

    exit(EXIT_SUCCESS);
}

int main() {
    struct sigaction act, act_int;

    // Set up signal handler for SIGUSR1
    memset(&act, 0, sizeof(struct sigaction));
    act.sa_sigaction = handle_directory_change;
    act.sa_flags = SA_SIGINFO;
    sigaction(SIGUSR1, &act, NULL);

    // Set up signal handler for SIGINT
    memset(&act_int, 0, sizeof(struct sigaction));
    act_int.sa_handler = handle_sigint;
    sigaction(SIGINT, &act_int, NULL);

    // Variables for storing initial and current directory status
    struct stat initial_stat, current_stat;
    if (stat(IN_PATH, &initial_stat) == -1) {
        perror("Error getting directory status");
        return EXIT_FAILURE;
    }

    // Loop for monitoring directory changes
    while (1) {
        if (stat(IN_PATH, &current_stat) == -1) {
            perror("Error getting directory status");
            return EXIT_FAILURE;
        }

        // Check if there was any change in the directory's timestamp
        if (current_stat.st_mtime != initial_stat.st_mtime) {
            // If there's a change, signal the parent process
            kill(getpid(), SIGUSR1);
            initial_stat = current_stat; // Update the status
        }
        sleep(5); // Wait before checking the directory again
    }

    return 0;
}
