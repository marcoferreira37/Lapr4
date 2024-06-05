package plugin;

import java.util.Map;

public class RuleScore {

    private static int QUESTION1 = 5;
    private static int QUESTION2 = 10;
    private static int QUESTION3 = 5;
    private static int QUESTION4 = 5;
    private static int QUESTION5 = 5;
    private static int QUESTION6 = 5;
    private static int QUESTION7 = 5;
    private static int QUESTION8 = 5;



    public static int calculateScore(Map<String, Map<String, String>> map, int score) {

        for (String s : map.keySet()) {
            if (s.equals("Question1")) {
                for (String answerCorreta : map.get(s).keySet()) {
                    if (answerCorreta.equals(map.get(s).get(answerCorreta))) {
                        System.out.println("Score in question 1: " + QUESTION1);
                        score += QUESTION1;
                    }

                }
            }
            if (s.equals("Question2")) {
                for (String setDasRespsotasCertas : map.get(s).keySet()) {
                    if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                        System.out.println("Score in question 2: " + QUESTION2);
                    score += QUESTION2;

                }
            }
            if (s.equals("Question3")) {
                for (String setDasRespsotasCertas : map.get(s).keySet()) {
                    if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                        System.out.println("Score in question 3: " + QUESTION3);
                    score += QUESTION3;

                }
            }
            if (s.equals("Question4")) {
                for (String setDasRespsotasCertas : map.get(s).keySet()) {
                    if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                        System.out.println("Score in question 4: " + QUESTION4);
                    score += QUESTION4;

                }
            }
            if (s.equals("Question5")) {
                for (String setDasRespsotasCertas : map.get(s).keySet()) {
                    if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                        System.out.println("Score in question 5: " + QUESTION5);
                    score += QUESTION5;

                }
            }
            if (s.equals("Question6")) {
                for (String setDasRespsotasCertas : map.get(s).keySet()) {
                    if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                        System.out.println("Score in question 6: " + QUESTION6);
                    score += QUESTION6;

                }
            }
            if (s.equals("Question7")) {
                for (String setDasRespsotasCertas : map.get(s).keySet()) {
                    if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                        System.out.println("Score in question 7: " + QUESTION7);
                    score += QUESTION7;

                }
            }
            if (s.equals("Question8")) {
                for (String setDasRespsotasCertas : map.get(s).keySet()) {
                    if (setDasRespsotasCertas.equals(map.get(s).get(setDasRespsotasCertas)))
                        System.out.println("Score in question 8: " + QUESTION8);
                    score += QUESTION8;

                }

            }

        }
        return  score;
    }
}


