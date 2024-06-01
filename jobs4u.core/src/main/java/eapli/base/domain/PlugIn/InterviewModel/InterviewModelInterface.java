package eapli.base.domain.PlugIn.InterviewModel;

import java.io.File;
import java.io.IOException;

public interface InterviewModelInterface {

    /**
     * Generates a text file at the specified path.
     *
     * @param path the path where the text file will be created
     * @return the generated text file
     */
    File generateTxt(String path);

    /**
     * Evaluates the content of a file at the specified path.
     *
     * @param path the path of the file to be evaluated
     * @return the score based on the evaluation
     * @throws IOException if the file is not found or cannot be read
     */
    int evaluate(String path) throws IOException;
}

