package eapli.base.domain.PlugIn.JobRequirements;

import java.io.File;
import java.io.IOException;

public interface JobRequirementInterface {

    /**
     * Generates a text file at the specified path.
     *
     * @param path the path where the text file will be created
     * @return the generated text file
     */
    File generateTxt(String path);

    /**
     * Validates the content of a file at the specified path.
     *
     * @param path the path of the file to be validated
     * @return the validation result as a String
     * @throws IOException if the file is not found or cannot be read
     */
    String validate(String path) throws IOException;
}
