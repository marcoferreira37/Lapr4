package plugin;

import eapli.framework.io.util.Console;

public class Main {
    public static void main(String[] args) {
        InterviewModel interviewModel = new InterviewModel();
        showMenu(interviewModel);
    }

    private static void showMenu(InterviewModel interviewModel) {
        while (true) {
            System.out.println("1. Evaluete the grade for a Interview");
            System.out.println("2. User Story 2");
            System.out.println("3. User Story 3");
            System.out.println("4. Exit");

            int choice = Console.readInteger("Choose an option: ");

            switch (choice) {
                case 1:
                    System.out.println("####### Evaluete the grade for a Interview #######");
                    System.out.println();
                    String file = Console.readLine("Insert the file path: ");
                    interviewModel.enterStart(file);
                    break;
                case 2:
                    // Execute User Story 2
                    break;
                case 3:
                    // Execute User Story 3
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}