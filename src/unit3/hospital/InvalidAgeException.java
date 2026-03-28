package unit3.hospital;

public class InvalidAgeException extends Exception {
    private final int invalidAge;
    private final String errorCode;
    private final String suggestedAction;
    
    public InvalidAgeException(int invalidAge, String message, String errorCode, String suggestedAction) {
        super(message);
        this.invalidAge = invalidAge;
        this.errorCode = errorCode;
        this.suggestedAction = suggestedAction;
    }
    
    public int getInvalidAge() {
        return invalidAge;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
    
    public String getSuggestedAction() {
        return suggestedAction;
    }
    
    @Override
    public String toString() {
        return String.format("InvalidAgeException[%s]: %s (Age: %d) - Action: %s",
                           errorCode, getMessage(), invalidAge, suggestedAction);
    }
}
