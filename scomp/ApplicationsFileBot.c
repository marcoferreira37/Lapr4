#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>
#include <dirent.h>

#define IN_PATH "Email-Bot-Output-Example"
#define OUT_PATH "SharedFolder"
#define NUM_WORKERS 3

void copyFiles() {
    DIR *dir;
    struct dirent *entry;

    // opens the entry directory
    dir = opendir(IN_PATH);
    if (dir == NULL) {
        perror("opendir");
        exit(EXIT_FAILURE);
    }

    while ((entry = readdir(dir)) != NULL) {
        if (strcmp(entry->d_name, ".") == 0 || strcmp(entry->d_name, "..") == 0) {
            continue;
        }

        if (strstr(entry->d_name, "candidate_data") != NULL) {
            char src_path[1024];
            char dest_dir[1024];
            char subfolder_path[1024];

            snprintf(src_path, sizeof(src_path), "%s/%s", IN_PATH, entry->d_name);
            FILE *file = fopen(src_path, "r");
            if (file == NULL) {
                perror("fopen");
                continue;
            }

            char candidate_name[1024];
            if (fgets(candidate_name, sizeof(candidate_name), file) == NULL) {
                fclose(file);
                continue;
            }
            candidate_name[strcspn(candidate_name, "\n")] = '\0';
            snprintf(dest_dir, sizeof(dest_dir), "%s/%s", OUT_PATH, candidate_name);
            mkdir(dest_dir, 0777);

            char prefix[256];
            sscanf(entry->d_name, "%[^-]", prefix);  // assuming that the prefix until the first '-' is the identifier
            snprintf(subfolder_path, sizeof(subfolder_path), "%s/%s-%s", dest_dir, candidate_name, prefix);
            mkdir(subfolder_path, 0777);  // creates the subfolder for the arquives

            rewinddir(dir);  // rewinds to get the arquives again
            struct dirent *file_entry;
            while ((file_entry = readdir(dir)) != NULL) {
                if (strcmp(file_entry->d_name, ".") == 0 || strcmp(file_entry->d_name, "..") == 0) {
                    continue;
                }
                if (strncmp(file_entry->d_name, prefix, strlen(prefix)) == 0) {
                    char src_file[1024];
                    char dest_file[1024];
                    snprintf(src_file, sizeof(src_file), "%s/%s", IN_PATH, file_entry->d_name);
                    snprintf(dest_file, sizeof(dest_file), "%s/%s", subfolder_path, file_entry->d_name);
                    if (rename(src_file, dest_file) != 0) {
                        perror("rename");
                    }
                }
            }

            fclose(file);
        }
    }

    closedir(dir);
}

// function for handling the directory change
void handle_directory_change(int signo, siginfo_t *info, void *context){
    printf("The directory was changed!\n");

    // Cria um novo processo filho
    pid_t pid;
    pid = fork();
    if (pid == -1) {
        perror("Error creating the child process");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        copyFiles(); // calls the method to copy arquives
        exit(EXIT_SUCCESS);
    }
}

// Function to handle SIGINT signal
void handle_sigint(int signo) {
    printf("\nRecebido sinal SIGINT. Terminando o programa...\n");

    // Kills all child processes
    kill(0, SIGTERM);

    // Waits for the child processes to end
    while (wait(NULL) > 0);

    exit(EXIT_SUCCESS);
}

int main() {
    struct sigaction act,act_int;

    memset(&act, 0, sizeof(struct sigaction));
    act.sa_sigaction = handle_directory_change;
    act.sa_flags = SA_SIGINFO;
    sigaction(SIGUSR1, &act, NULL); // Configures the action for SIGURS1

    memset(&act_int, 0, sizeof(struct sigaction));
    act_int.sa_handler = handle_sigint;
    sigaction(SIGINT, &act_int, NULL); // Configures action for SIGINT
    struct stat initial_stat, current_stat;
    if (stat(IN_PATH, &initial_stat) == -1) {
        perror("Erro ao obter o status do diretório");
        return EXIT_FAILURE;
    }

    // Loop for verifying changes in the directory
        while (1) {
        if (stat(IN_PATH, &current_stat) == -1) {
            perror("Erro ao obter o status do diretório");
            return EXIT_FAILURE;
        }

        // Verifying if there was any change in the timestamp
        if (current_stat.st_mtime != initial_stat.st_mtime) {
            //If there is any change, sign to father process
            kill(getpid(), SIGUSR1);
            initial_stat = current_stat; // Updates the status
        }
        sleep(5); // waits 2 seconds before verifying the directory
    }

    return 0;
}
