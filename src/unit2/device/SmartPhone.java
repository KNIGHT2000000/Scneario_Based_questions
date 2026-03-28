package unit2.device;

public class SmartPhone implements Callable, Camera {
    private String brand;
    private String model;
    private String phoneNumber;
    private boolean isInCall;
    private int photoCount;
    private int videoCount;
    
    public SmartPhone(String brand, String model, String phoneNumber) {
        this.brand = brand;
        this.model = model;
        this.phoneNumber = phoneNumber;
        this.isInCall = false;
        this.photoCount = 0;
        this.videoCount = 0;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    // Callable interface implementation
    @Override
    public void makeCall(String phoneNumber) {
        if (!isInCall) {
            System.out.println(brand + " " + model + " is calling " + phoneNumber + "...");
            isInCall = true;
            System.out.println("Call connected.");
        } else {
            System.out.println("Already in a call. Please end current call first.");
        }
    }
    
    @Override
    public void receiveCall(String caller) {
        if (!isInCall) {
            System.out.println("Incoming call from " + caller + " on " + brand + " " + model);
            System.out.println("Call answered.");
            isInCall = true;
        } else {
            System.out.println("Cannot receive call. Already in another call.");
        }
    }
    
    @Override
    public void endCall() {
        if (isInCall) {
            System.out.println("Call ended on " + brand + " " + model);
            isInCall = false;
        } else {
            System.out.println("No active call to end.");
        }
    }
    
    @Override
    public void checkVoicemail() {
        System.out.println("Checking voicemail on " + brand + " " + model);
        System.out.println("You have 3 new voicemail messages.");
    }
    
    // Camera interface implementation
    @Override
    public void takePhoto() {
        System.out.println("Taking photo with " + brand + " " + model + " camera...");
        System.out.println("Photo captured successfully!");
        photoCount++;
        System.out.println("Total photos taken: " + photoCount);
    }
    
    @Override
    public void recordVideo() {
        System.out.println("Recording video with " + brand + " " + model + " camera...");
        System.out.println("Video recording started...");
        System.out.println("Video recording stopped and saved!");
        videoCount++;
        System.out.println("Total videos recorded: " + videoCount);
    }
    
    @Override
    public void captureSelfie() {
        System.out.println("Capturing selfie with " + brand + " " + model + " front camera...");
        System.out.println("Selfie captured successfully!");
        photoCount++;
        System.out.println("Total photos taken: " + photoCount);
    }
    
    @Override
    public void viewGallery() {
        System.out.println("Opening gallery on " + brand + " " + model);
        System.out.println("Gallery contents:");
        System.out.println("- Photos: " + photoCount);
        System.out.println("- Videos: " + videoCount);
        System.out.println("Total media files: " + (photoCount + videoCount));
    }
    
    // Additional smartphone-specific methods
    public void browseInternet() {
        System.out.println("Browsing internet on " + brand + " " + model);
        System.out.println("Connected to Wi-Fi and browsing web...");
    }
    
    public void sendSMS(String message, String recipient) {
        System.out.println("Sending SMS to " + recipient + " from " + brand + " " + model);
        System.out.println("Message: \"" + message + "\"");
        System.out.println("Message sent successfully!");
    }
    
    public void playMusic() {
        System.out.println("Playing music on " + brand + " " + model);
        System.out.println("Now playing your favorite songs...");
    }
    
    public void displayDeviceInfo() {
        System.out.println("Smartphone Information:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("In Call: " + (isInCall ? "Yes" : "No"));
        System.out.println("Photos Taken: " + photoCount);
        System.out.println("Videos Recorded: " + videoCount);
        System.out.println("------------------------");
    }
    
    // Demonstrate multiple interface functionality
    public void demonstrateMultipleInterfaces() {
        System.out.println("=== Multiple Interface Demonstration ===");
        System.out.println("This SmartPhone implements both Callable and Camera interfaces");
        System.out.println("It can perform both calling and camera functions seamlessly");
        System.out.println();
        
        // Use interface references
        Callable callableDevice = this;
        Camera cameraDevice = this;
        
        System.out.println("Using Callable interface reference:");
        callableDevice.makeCall("555-1234");
        callableDevice.endCall();
        
        System.out.println("\nUsing Camera interface reference:");
        cameraDevice.takePhoto();
        cameraDevice.recordVideo();
    }
}
