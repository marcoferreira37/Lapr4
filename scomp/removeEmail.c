#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <unistd.h>
#include <sys/stat.h>
#include <string.h>

#define DIRECTORY_PATH "Email-Bot-Output"

void deleteFilesInDirectory(const char *dir_path) {
    DIR *dir;
    struct dirent *entry;

    // opens directory
    dir = opendir(dir_path);
    if (dir == NULL) {
        perror("Error opening directory");
        exit(EXIT_FAILURE);
    }

    // Goes through the arquives in the directory
    while ((entry = readdir(dir)) != NULL) {
        // ignores "." and ".."
        if (strcmp(entry->d_name, ".") != 0 && strcmp(entry->d_name, "..") != 0) {
            char file_path[1024];
            snprintf(file_path, sizeof(file_path), "%s/%s", dir_path, entry->d_name);

            // removes the arquive
            if (remove(file_path) == -1) {
                perror("Error removing file ");
                exit(EXIT_FAILURE);
            }

            printf("File removed: %s\n", file_path);
        }
    }

    closedir(dir); // close the directory
}


