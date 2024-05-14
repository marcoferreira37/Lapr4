package eapli.base.domain;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public final class Password implements ValueObject, Serializable {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
    private static final int DEFAULT_LENGTH = 12;


    private static final long serialVersionUID = 1L;

    @Column(name = "password")
    private final String value;

    public Password() {
        // for ORM only
        value = null;
    }

    public Password(final String password) {
        Preconditions.nonNull(password);
        value = password;
    }

    /**
     * Constructs an encoded password ensuring the raw password adheres to the
     * password policy.
     *
     * @param rawPassword
     * @param policy
     * @param encoder
     *
     * @return the new Password or an empty Optional if the passwords does not
     *         satisfies the password policy
     */
    public static Optional<Password> encodedAndValid(final String rawPassword,
                                                     final PasswordPolicy policy,
                                                     final PasswordEncoder encoder) {
        Preconditions.noneNull(rawPassword, policy, encoder);

        if (policy.isSatisfiedBy(rawPassword)) {
            return Optional.of(new Password(encoder.encode(rawPassword)));
        }
        return Optional.empty();
    }

//    public static Password generatePassword1() {
//        SecureRandom random = new SecureRandom();
//        StringBuilder password = new StringBuilder();
//
//        for (int i = 0; i < DEFAULT_LENGTH; i++) {
//            int randomIndex = random.nextInt(CHARACTERS.length());
//            password.append(CHARACTERS.charAt(randomIndex));
//        }
//
//        return new Password(password.toString());
//    }
    public static Password generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Adiciona pelo menos um caractere de cada tipo exigido
        password.append(getRandomUpperCase(random));
        password.append(getRandomDigit(random));
        password.append(getRandomSpecialCharacter(random));


        int remainingLength = Password.DEFAULT_LENGTH - 3; // Descontando os caracteres já adicionados
        for (int i = 0; i < remainingLength; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(randomIndex));
        }

        return new Password(password.toString());
    }
    private static char getRandomUpperCase(SecureRandom random) {
        return (char) ('A' + random.nextInt(26));
    }

    private static char getRandomDigit(SecureRandom random) {
        return (char) ('0' + random.nextInt(10));
    }

    private static char getRandomSpecialCharacter(SecureRandom random) {
        String specialCharacters = "!@#$%^&*()-_=+";
        int randomIndex = random.nextInt(specialCharacters.length());
        return specialCharacters.charAt(randomIndex);
    }


    /**
     * Let's not return the password by mistake.
     */
    @Override
    public String toString() {
        return generatePassword().value();
    }

    /**
     * For supporting Spring Security UserDetails
     */
    String value() {
        return value;
    }
}
