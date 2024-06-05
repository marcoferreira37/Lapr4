package eapli.base.usermanagement.application;

import eapli.base.usermanagement.application.controllers.UploadTextFileController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadTextFileControllerTest {
    private UploadTextFileController controller;

    @BeforeEach
    public void setUp() {
        controller = new UploadTextFileController();
    }

    @Test
    public void testAllCandidates() {
        // Test if the method returns non-null Iterable
        assertNotNull(controller.allCandidates());
    }

    @Test
    public void testUploadFile() {
        // Test uploading a file with a sample curriculum
        String curriculum = "Sample curriculum content";
        controller.uploadFile(curriculum);

        // Verify that the file is created and contains the correct content
        File file = new File("jobs4u.core/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/file.txt");
        assertTrue(file.exists());

        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(file.getPath())));
            assertEquals(curriculum, fileContent.trim());
        } catch (IOException e) {
            fail("Failed to read file content: " + e.getMessage());
        } finally {
            // Clean up - delete the created file after the test
            file.delete();
        }
    }
}
