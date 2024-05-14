package eapli.base.app.common.console.ui.components;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {




    static public String readLineFromConsole(String prompt) {
        try {
            System.out.println("\n" + prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
