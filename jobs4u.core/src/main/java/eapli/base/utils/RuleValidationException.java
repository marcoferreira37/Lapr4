package eapli.base.utils;

public class RuleValidationException extends Exception{
    public RuleValidationException() {
    }

    public RuleValidationException(String message) {
        super(message);
    }

    public RuleValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuleValidationException(Throwable cause) {
        super(cause);
    }

    protected RuleValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
