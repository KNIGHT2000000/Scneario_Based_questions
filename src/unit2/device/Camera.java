package unit2.device;

public interface Camera {
    void takePhoto();
    void recordVideo();
    void captureSelfie();
    void viewGallery();
    
    // Default method
    default void displayCameraInfo() {
        System.out.println("Camera status: Ready to capture moments");
    }
    
    // Static method
    static void displayCameraFeatures() {
        System.out.println("Camera Interface Features:");
        System.out.println("- Take photos");
        System.out.println("- Record videos");
        System.out.println("- Capture selfies");
        System.out.println("- View gallery");
    }
}
