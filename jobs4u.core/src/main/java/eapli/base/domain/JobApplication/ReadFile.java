//package eapli.base.domain.JobApplication;
//
//import eapli.base.domain.jobOpening.JobReference;
//import lombok.Getter;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Calendar;
//
//public class ReadFile {
//    String nomeFicheiro = "C:\\Users\\Utilizador\\Desktop\\sem4pi-23-24-2dh3\\final\\scomp\\IBM-000123\\1-candidate-data.txt";
//    static AttachedFile file = readFile(nomeFicheiro);
//
//    static int id = 1;
//
//
//
//
//    public static AttachedFile readFile(String nomeFicheiro) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFicheiro))) {
//            String jobReference = reader.readLine();
//            String attachedEmail = reader.readLine();
//            Calendar applicationData = Calendar.getInstance();
//            String applicationStatus = "Acepted";
//            int applicationID = id;
//
////            IBM-000123
////            johndoe@email.com
////            John Doe
////            961234567
//
//            if (applicationData == null || attachedEmail == null) {
//                throw new IOException("ERROR: Ficheiro mal formatado");
//            }
//            System.out.println("Informações lidas do ficheiro:");
//            System.out.println("Email: "+ attachedEmail);
//            System.out.println("applicationData: " + applicationData);
//            System.out.println("applicationStatus: "+applicationStatus);
//            System.out.println("applicationID: "+applicationID);
//            id++;
//
//
//
//
//            return new AttachedFile(attachedEmail, applicationData, applicationStatus, applicationID, file);
//        } catch (IOException e) {
//            System.err.println("Erro ao ler o ficheiro: " + e.getMessage());
//            return null;
//        }
//
//
//    }
//}
