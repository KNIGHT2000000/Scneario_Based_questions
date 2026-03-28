package unit2.device;

public interface Callable {
    void makeCall(String phoneNumber);
    void receiveCall(String caller);
    void endCall();
    void checkVoicemail();
    
    // Default method (Java 8+)
    default void displayCallStatus() {
        System.out.println("Call status: Ready to make/receive calls");
    }
    
    // Static method (Java 8+)
    static void displayCallFeatures() {
        System.out.println("Callable Interface Features:");
        System.out.println("- Make calls");
        System.out.println("- Receive calls");
        System.out.println("- End calls");
        System.out.println("- Check voicemail");
    }
}
