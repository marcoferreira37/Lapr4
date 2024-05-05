#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <unistd.h>
#include <sys/stat.h>
#include <string.h>

#define DIRECTORY_PATH "SharedFolder"

void deleteFilesInDirectory(const char *dir_path) {
    DIR *dir;
    struct dirent *entry;

    // open directory
    dir = opendir(dir_path);
    if (dir == NULL) {
        perror("Error opening directory");
        exit(EXIT_FAILURE);
    }

    // goes through arquives in the directory
    while ((entry = readdir(dir)) != NULL) {
        // ignore "." e ".."
        if (strcmp(entry->d_name, ".") != 0 && strcmp(entry->d_name, "..") != 0) {
            char file_path[1024];
            snprintf(file_path, sizeof(file_path), "%s/%s", dir_path, entry->d_name);

            // removes arquive
            if (remove(file_path) == -1) {
                perror("Error removing file");
                exit(EXIT_FAILURE);
            }

            printf("File removed: %s\n", file_path);
        }
    }

    closedir(dir); //close directory
}

int main() {
    // calls method to delete files from directory
    deleteFilesInDirectory(DIRECTORY_PATH);

    return 0;
}
