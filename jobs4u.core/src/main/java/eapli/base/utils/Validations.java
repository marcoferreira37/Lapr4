package eapli.base.utils;

public class Validations {

    private Validations() {
        // ensure utility
    }

    public static void notNull(Object... objs) throws ValidationException {
        for (Object obj : objs) {
            if (obj == null) {
                throw new ValidationException("Objects must not be null!");
            }
        }
    }

    public static void notBlank(String... strs) throws ValidationException {
        for (String str : strs) {
            if (str.isBlank()) {
                throw new ValidationException("Objects must not be blank!");
            }
        }
    }

    public static void isInteger(String... str) throws ValidationException {
        for (String s : str) {
            if (!s.matches("-?[0-9]+")) {
                throw new ValidationException("String must be numeric!");
            }
        }
    }

    public static void isPositive(double... ints) throws ValidationException {
        for (Double s : ints) {
            if (s <= 0) {
                throw new ValidationException("Number must be Positive!");
            }
        }
    }

    public static void isNotPositive(double... ints) throws ValidationException {
        for (Double s : ints) {
            if (s > 0) {
                throw new ValidationException("Number must be Negative or Zero!");
            }
        }
    }

    public static void isNegative(double... ints) throws ValidationException {
        for (Double s : ints) {
            if (s >= 0) {
                throw new ValidationException("Number must be Negative!");
            }
        }
    }

    public static void isNotNegative(double... ints) throws ValidationException {
        for (Double s : ints) {
            if (s < 0) {
                throw new ValidationException("Number must be Positive or Zero!");
            }
        }
    }

    public static void isZero(double... ints) throws ValidationException {
        for (Double s : ints) {
            if (s != 0) {
                throw new ValidationException("Number must be Zero!");
            }
        }
    }

    public static void isNotZero(double... ints) throws ValidationException {
        for (Double s : ints) {
            if (s == 0) {
                throw new ValidationException("Number must not be Zero!");
            }
        }
    }

    public static void mustMatch(String str1, String regex) throws ValidationException {
        if (!str1.matches(regex)) {
            throw new ValidationException("Strings must match the regex "+ regex+"!");
        }
    }

    public static void mustNotMatch(String str1, String regex) throws ValidationException {
        if (str1.matches(regex)) {
            throw new ValidationException("Strings must not match the regex "+ regex+"!");
        }
    }

    public static void isTrue(boolean... bools) throws ValidationException {
        for (Boolean b : bools) {
            if (!b) {
                throw new ValidationException("Boolean must be true!");
            }
        }
    }

    public static void isFalse(boolean... bools) throws ValidationException {
        for (Boolean b : bools) {
            if (b) {
                throw new ValidationException("Boolean must be false!");
            }
        }
    }

}
