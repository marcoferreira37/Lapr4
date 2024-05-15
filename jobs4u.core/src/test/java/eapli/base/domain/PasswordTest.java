package eapli.base.domain;

import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    /**
     * Test of encodedAndValid method, of class Password.
     * Test that an encoded password is created and is valid.
     */
    @Test
    public void testEncodedAndValid() {
        String rawPassword = "password123";
        PasswordPolicy policy = new PasswordPolicy() {
            @Override
            public boolean isSatisfiedBy(String password) {
                return password.length() >= 8;
            }
        };
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Password> encodedPassword = Password.encodedAndValid(rawPassword, policy, encoder);
        assertTrue(encodedPassword.isPresent(), "Encoded password should be present");
        assertTrue(encoder.matches(rawPassword, encodedPassword.get().value()), "Encoded password should match raw password");
    }

    /**
     * Test of encodedAndValid method, of class Password.
     * Test if the password is not null.
     */
    @Test
    public void testGeneratePasswordNotNull() {
        Password password = Password.generatePassword();
        assertNotNull(password, "Generated password should not be null");
    }

    /**
     * Test of encodedAndValid method, of class Password.
     * Test if the password has the default length.
     */
    @Test
    public void testGeneratePasswordLength() {
        Password password = Password.generatePassword();
        assertEquals(Password.DEFAULT_LENGTH, password.value().length(), "Generated password should have default length");
    }

    /**
     * Test of encodedAndValid method, of class Password.
     * Test if the password contains at least one uppercase character.
     */
    @Test
    public void testGeneratePasswordContainsUpperCase() {
        Password password = Password.generatePassword();
        assertTrue(containsUpperCase(password.value()), "Generated password should contain at least one uppercase character");
    }

    /**
     * Test of encodedAndValid method, of class Password.
     * Test if the password contains at least one digit.
     */
    @Test
    public void testGeneratePasswordContainsDigit() {
        Password password = Password.generatePassword();
        assertTrue(containsDigit(password.value()), "Generated password should contain at least one digit");
    }

    /**
     * Test of encodedAndValid method, of class Password.
     * Test if the password contains at least one special character.
     */
    @Test
    public void testGeneratePasswordContainsSpecialCharacter() {
        Password password = Password.generatePassword();
        assertTrue(containsSpecialCharacter(password.value()), "Generated password should contain at least one special character");
    }

    /**
     * Test of encodedAndValid method, of class Password.
     * Test if the password is empty.
     */
    @Test
    public void testGeneratePasswordNotEmpty() {
        Password password = Password.generatePassword();
        assertNotEquals("", password.value(), "Generated password should not be empty");
    }

    /**
     * Test of encodedAndValid method, of class Password.
     * Test if the password is not a single space.
     */
    @Test
    public void testGeneratePasswordNotSingleSpace() {
        Password password = Password.generatePassword();
        assertNotEquals(" ", password.value(), "Generated password should not be a single space");
    }

    /**
     * Test of encodedAndValid method, of class Password.
     * @param password the password to check
     * @return true if the password contains at least one uppercase character
     */
    private boolean containsUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Test of encodedAndValid method, of class Password.
     * @param password the password to check
     * @return true if the password contains at least one digit
     */
    private boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Test of encodedAndValid method, of class Password.
     * @param password the password to check
     * @return true if the password contains at least one special character
     */
    private boolean containsSpecialCharacter(String password) {
        String specialCharacters = "!@#$%^&*()-_=+";
        for (char c : password.toCharArray()) {
            if (specialCharacters.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}
