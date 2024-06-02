package eapli.base.usermanagement.application.controllers;
import eapli.base.usermanagement.application.controllers.EditJobOpeningController;
import eapli.base.domain.Editable;
import eapli.framework.io.util.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class EditJobOpeningControllerTest {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private MockedStatic<Console> mockConsole;
    private List<Editable> edits = new ArrayList<>();
    @BeforeEach
    public void setUp() {
        mockConsole = Mockito.mockStatic(Console.class);
    }
    @AfterEach
    public void tearDown() {
        mockConsole.close();
    }

    @Test
    public void shouldReturnValidStringWhenUserConfirmsInput() {
        when(Console.readLine("New " + Editable.Description + " :")).thenReturn("Valid input");
        when(Console.readBoolean("Do you confirm this input? (y/n)")).thenReturn(true);

        String result = editString(Editable.Description);

        assertEquals("Valid input", result);
    }

    @Test
    public void shouldReturnEmptyStringWhenUserInputsEmptyString() {
        when(Console.readLine("New " + Editable.Description + " :")).thenReturn("");
        when(Console.readBoolean("Do you confirm this input? (y/n)")).thenReturn(true);

        String result = editString(Editable.Description);

        assertEquals("", result);
    }


    public String editString(Editable edit) {
        do {
            String s = Console.readLine("New " + edit + " :");
            if (Console.readBoolean("Do you confirm this input? (y/n)")){
                if ( s.length() <= 255) {
                    return s;
                } else {
                    System.out.println(ANSI_RED + "Invalid input!" + ANSI_RESET);
                }
            }
        } while (true);

    }

    @Test
    public void shouldNotAddEditsWhenUserDoesNotConfirm() {
        for (Editable edit : Editable.values()) {
            when(Console.readBoolean("Do you want to update " + edit.toString() + "? (y/n)")).thenReturn(false);
        }

       addEdits();

        assertTrue(edits.isEmpty());
    }

    public void addEdits() {
        for (Editable edit : Editable.values()) {
            if (Console.readBoolean("Do you want to update " + edit.toString() + "? (y/n)")) {
                edits.add(edit);
            }
        }
    }

    @Test
    public void shouldReturnValidNumberWhenUserInputsValidNumber() {
        when(Console.readInteger("New " + Editable.Vacancies_Number + " : ")).thenReturn(5);

        int result = editNumber(Editable.Vacancies_Number);

        assertEquals(5, result);
    }

    @Test
    public void shouldReturnZeroWhenUserInputsInvalidNumber() {
        when(Console.readInteger("New " + Editable.Vacancies_Number + " : ")).thenReturn(-1);

        int result = editNumber(Editable.Vacancies_Number);

        assertEquals(0, result);
    }

    public int editNumber(Editable atribute) {
        int number = Console.readInteger("New " + atribute + " : ");
        return number > 0 ? number : 0;
    }
}
