package plugin;

import eapli.framework.io.util.Console;

public class Main {
    public static void main(String[] args) {
        InterviewModel interviewModel = new InterviewModel();

        String file = Console.readLine("Insert the file path: ");
        interviewModel.enterStart(file);
    }
}