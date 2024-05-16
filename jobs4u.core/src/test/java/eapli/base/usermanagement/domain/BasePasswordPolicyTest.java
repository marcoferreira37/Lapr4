package eapli.base.usermanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasePasswordPolicyTest {

    @Test
    public void testIsSatisfiedBy_ValidPassword() {
        // Teste para verificar se a política de senha está satisfeita por uma senha válida.

        BasePasswordPolicy policy = new BasePasswordPolicy();
        String validPassword = "StrongPassword1";
        boolean satisfied = policy.isSatisfiedBy(validPassword);

        assertTrue(satisfied);
    }

    @Test
    public void testIsSatisfiedBy_NullOrEmptyPassword() {
        // Teste para verificar se a senha não está satisfeita por uma senha nula ou vazia.

        BasePasswordPolicy policy = new BasePasswordPolicy();
        String emptyPassword = "";

        boolean emptyResult = policy.isSatisfiedBy(emptyPassword);
        boolean nullResult = policy.isSatisfiedBy(null);

        assertFalse(emptyResult);
        assertFalse(nullResult);
    }

    @Test
    public void testStrength_StrongPassword() {
        // Teste para verificar a força de uma senha forte.

        BasePasswordPolicy policy = new BasePasswordPolicy();
        String strongPassword = "StrongPassword1";

        BasePasswordPolicy.PasswordStrength strength = policy.strength(strongPassword);

        assertEquals(BasePasswordPolicy.PasswordStrength.EXCELENT, strength);
    }

    @Test
    public void testStrength_WeakPassword() {
        // Teste para verificar a força de uma senha fraca.

        BasePasswordPolicy policy = new BasePasswordPolicy();
        String weakPassword = "weak";

        BasePasswordPolicy.PasswordStrength strength = policy.strength(weakPassword);

        assertEquals(BasePasswordPolicy.PasswordStrength.WEAK, strength);
    }

    @Test
    public void testGeneratePassword() {
        // Teste para verificar a geração de senha com base no nome.

        String firstName = "john";
        String generatedPassword = BasePasswordPolicy.generatePassword(firstName);

        assertNotNull(generatedPassword);
        assertTrue(generatedPassword.startsWith("John")); // Verifica se a senha começa com o nome fornecido.
    }

    @Test
    public void testIsSatisfiedBy_PasswordLengthLessThanSix() {
        BasePasswordPolicy policy = new BasePasswordPolicy();
        String shortPassword = "Abc12";
        boolean satisfied = policy.isSatisfiedBy(shortPassword);
        assertFalse(satisfied);
    }

    @Test
    public void testIsSatisfiedBy_PasswordWithoutDigit() {
        BasePasswordPolicy policy = new BasePasswordPolicy();
        String passwordWithoutDigit = "Abcdefgh";
        boolean satisfied = policy.isSatisfiedBy(passwordWithoutDigit);
        assertFalse(satisfied);
    }

    @Test
    public void testIsSatisfiedBy_PasswordWithoutCapital() {
        BasePasswordPolicy policy = new BasePasswordPolicy();
        String passwordWithoutCapital = "abcdefg1";
        boolean satisfied = policy.isSatisfiedBy(passwordWithoutCapital);
        assertFalse(satisfied);
    }

    @Test
    public void testStrength_LongPasswordWithSpecialCharacters() {
        BasePasswordPolicy policy = new BasePasswordPolicy();
        String strongPassword = "LongPassword!123";
        BasePasswordPolicy.PasswordStrength strength = policy.strength(strongPassword);
        assertEquals(BasePasswordPolicy.PasswordStrength.EXCELENT, strength);
    }

    @Test
    public void testStrength_ShortPassword() {
        BasePasswordPolicy policy = new BasePasswordPolicy();
        String shortPassword = "Short1";
        BasePasswordPolicy.PasswordStrength strength = policy.strength(shortPassword);
        assertEquals(BasePasswordPolicy.PasswordStrength.WEAK, strength);
    }

    @Test
    public void testGeneratePassword_ShortName() {
        String firstName = "j";
        String generatedPassword = BasePasswordPolicy.generatePassword(firstName);
        assertNotNull(generatedPassword);
        assertTrue(generatedPassword.startsWith("J"));
    }
}