package unit2.device;

public class SmartPhoneDemo {
    public static void main(String[] args) {
        System.out.println("=== Smart Device with Multiple Interfaces Demo ===\n");
        
        System.out.println("=== Creating SmartPhone Objects ===\n");
        
        SmartPhone phone1 = new SmartPhone("Apple", "iPhone 14", "555-1234");
        SmartPhone phone2 = new SmartPhone("Samsung", "Galaxy S23", "555-5678");
        SmartPhone phone3 = new SmartPhone("Google", "Pixel 7", "555-9012");
        
        System.out.println("=== Individual Device Information ===\n");
        
        phone1.displayDeviceInfo();
        phone2.displayDeviceInfo();
        phone3.displayDeviceInfo();
        
        System.out.println("=== Callable Interface Functions ===\n");
        
        System.out.println("Testing " + phone1.getBrand() + " " + phone1.getModel() + ":");
        phone1.makeCall("555-9999");
        phone1.checkVoicemail();
        phone1.endCall();
        phone1.receiveCall("555-8888");
        phone1.endCall();
        System.out.println();
        
        System.out.println("=== Camera Interface Functions ===\n");
        
        System.out.println("Testing " + phone2.getBrand() + " " + phone2.getModel() + ":");
        phone2.takePhoto();
        phone2.captureSelfie();
        phone2.recordVideo();
        phone2.viewGallery();
        System.out.println();
        
        System.out.println("=== Multiple Interface Demonstration ===\n");
        
        phone3.demonstrateMultipleInterfaces();
        System.out.println();
        
        System.out.println("=== Interface Reference Polymorphism ===\n");
        
        // Using interface references
        Callable callableRef = phone1;
        Camera cameraRef = phone2;
        
        System.out.println("Using Callable interface reference:");
        callableRef.displayCallStatus();
        callableRef.makeCall("555-1111");
        callableRef.endCall();
        System.out.println();
        
        System.out.println("Using Camera interface reference:");
        cameraRef.displayCameraInfo();
        cameraRef.takePhoto();
        cameraRef.viewGallery();
        System.out.println();
        
        System.out.println("=== Interface Static Methods ===\n");
        
        Callable.displayCallFeatures();
        System.out.println();
        Camera.displayCameraFeatures();
        System.out.println();
        
        System.out.println("=== Additional Smartphone Features ===\n");
        
        phone1.browseInternet();
        phone1.sendSMS("Hello, how are you?", "555-7777");
        phone1.playMusic();
        System.out.println();
        
        System.out.println("=== Multiple Interface Benefits ===\n");
        
        System.out.println("1. Multiple Inheritance of Behavior:");
        System.out.println("   - SmartPhone gets behavior from Callable interface");
        System.out.println("   - SmartPhone gets behavior from Camera interface");
        System.out.println("   - Java allows multiple interface implementation");
        System.out.println("   - Avoids diamond problem of multiple class inheritance");
        System.out.println();
        
        System.out.println("2. Contract-based Programming:");
        System.out.println("   - Interfaces define contracts (what to implement)");
        System.out.println("   - Classes provide implementations (how to implement)");
        System.out.println("   - Ensures consistent API across different implementations");
        System.out.println();
        
        System.out.println("3. Polymorphism:");
        System.out.println("   - Interface reference can point to any implementing class");
        System.out.println("   - Method calls resolved at runtime");
        System.out.println("   - Enables flexible, extensible code");
        System.out.println();
        
        System.out.println("4. Separation of Concerns:");
        System.out.println("   - Callable interface focuses on communication features");
        System.out.println("   - Camera interface focuses on photography features");
        System.out.println("   - SmartPhone combines both seamlessly");
        
        System.out.println("\n=== Real-world Analogy ===");
        System.out.println("A smartphone is like a Swiss Army knife:");
        System.out.println("- Multiple tools in one device");
        System.out.println("- Each tool has specific functionality");
        System.out.println("- All tools work together harmoniously");
        System.out.println("- User can access any tool when needed");
    }
}
