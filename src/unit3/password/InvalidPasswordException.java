package unit3.password;

public class InvalidPasswordException extends Exception {
    private final String password;
    private final String validationRule;
    private final String suggestion;
    
    public InvalidPasswordException(String password, String validationRule, String suggestion) {
        super("Password validation failed: " + validationRule);
        this.password = password;
        this.validationRule = validationRule;
        this.suggestion = suggestion;
    }
    
    public InvalidPasswordException(String password, String validationRule, String suggestion, Throwable cause) {
        super("Password validation failed: " + validationRule, cause);
        this.password = password;
        this.validationRule = validationRule;
        this.suggestion = suggestion;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getValidationRule() {
        return validationRule;
    }
    
    public String getSuggestion() {
        return suggestion;
    }
    
    public String getMaskedPassword() {
        if (password == null || password.isEmpty()) {
            return "[empty]";
        }
        return "*".repeat(password.length());
    }
    
    @Override
    public String toString() {
        return String.format(
            "InvalidPasswordException: %s\n" +
            "Password: %s\n" +
            "Rule Violated: %s\n" +
            "Suggestion: %s",
            getMessage(), getMaskedPassword(), validationRule, suggestion
        );
    }
}
