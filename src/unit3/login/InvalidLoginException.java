package unit3.login;

public class InvalidLoginException extends Exception {
    private final String username;
    private final String reason;
    private final int attemptCount;
    
    public InvalidLoginException(String username, String reason, int attemptCount) {
        super("Login failed for user '" + username + "': " + reason);
        this.username = username;
        this.reason = reason;
        this.attemptCount = attemptCount;
    }
    
    public InvalidLoginException(String username, String reason, int attemptCount, Throwable cause) {
        super("Login failed for user '" + username + "': " + reason, cause);
        this.username = username;
        this.reason = reason;
        this.attemptCount = attemptCount;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getReason() {
        return reason;
    }
    
    public int getAttemptCount() {
        return attemptCount;
    }
    
    public boolean isAccountLocked() {
        return attemptCount >= 3;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InvalidLoginException: ").append(getMessage()).append("\n");
        sb.append("Username: ").append(username).append("\n");
        sb.append("Reason: ").append(reason).append("\n");
        sb.append("Attempt Count: ").append(attemptCount).append("\n");
        sb.append("Account Status: ").append(isAccountLocked() ? "LOCKED" : "Active");
        return sb.toString();
    }
}
