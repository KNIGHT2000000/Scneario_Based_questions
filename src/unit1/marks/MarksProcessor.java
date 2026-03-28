package unit1.marks;

public class MarksProcessor {
    
    public static void modifyPrimitive(int marks) {
        System.out.println("Inside modifyPrimitive method:");
        System.out.println("Received marks: " + marks);
        
        marks = marks + 10;
        
        System.out.println("Modified marks inside method: " + marks);
        System.out.println("Exiting modifyPrimitive method");
    }
    
    public static void modifyObject(Marks marksObj) {
        System.out.println("Inside modifyObject method:");
        System.out.println("Received object - Student: " + marksObj.getStudentName() + 
                          ", Marks: " + marksObj.getMarks());
        
        marksObj.setMarks(marksObj.getMarks() + 5);
        
        System.out.println("Modified object marks inside method: " + marksObj.getMarks());
        System.out.println("Exiting modifyObject method");
    }
    
    public static void reassignObject(Marks marksObj) {
        System.out.println("Inside reassignObject method:");
        System.out.println("Original object - Student: " + marksObj.getStudentName() + 
                          ", Marks: " + marksObj.getMarks());
        
        marksObj = new Marks(9999, "Temporary Student", 100);
        
        System.out.println("Reassigned object - Student: " + marksObj.getStudentName() + 
                          ", Marks: " + marksObj.getMarks());
        System.out.println("Exiting reassignObject method");
    }
    
    public static void modifyArray(int[] marksArray) {
        System.out.println("Inside modifyArray method:");
        System.out.println("Original array values:");
        for (int i = 0; i < marksArray.length; i++) {
            System.out.println("marksArray[" + i + "] = " + marksArray[i]);
        }
        
        for (int i = 0; i < marksArray.length; i++) {
            marksArray[i] = marksArray[i] + 2;
        }
        
        System.out.println("Modified array values:");
        for (int i = 0; i < marksArray.length; i++) {
            System.out.println("marksArray[" + i + "] = " + marksArray[i]);
        }
        System.out.println("Exiting modifyArray method");
    }
    
    public static void demonstrateParameterPassing() {
        System.out.println("=== Java Parameter Passing Mechanism ===\n");
        
        System.out.println("1. PASS-BY-VALUE for Primitive Types:");
        int primitiveMarks = 75;
        System.out.println("Before method call - primitiveMarks: " + primitiveMarks);
        modifyPrimitive(primitiveMarks);
        System.out.println("After method call - primitiveMarks: " + primitiveMarks);
        System.out.println("Conclusion: Primitive types are passed by value (copy)");
        System.out.println("Changes inside method don't affect original variable\n");
        
        System.out.println("2. PASS-BY-VALUE for Object References:");
        Marks studentMarks = new Marks(1001, "John Doe", 80);
        System.out.println("Before method call - Student: " + studentMarks.getStudentName() + 
                          ", Marks: " + studentMarks.getMarks());
        modifyObject(studentMarks);
        System.out.println("After method call - Student: " + studentMarks.getStudentName() + 
                          ", Marks: " + studentMarks.getMarks());
        System.out.println("Conclusion: Object reference is passed by value");
        System.out.println("But object state can be modified through the reference\n");
        
        System.out.println("3. REASSIGNING OBJECT REFERENCES:");
        Marks studentMarks2 = new Marks(1002, "Jane Smith", 85);
        System.out.println("Before method call - Student: " + studentMarks2.getStudentName() + 
                          ", Marks: " + studentMarks2.getMarks());
        reassignObject(studentMarks2);
        System.out.println("After method call - Student: " + studentMarks2.getStudentName() + 
                          ", Marks: " + studentMarks2.getMarks());
        System.out.println("Conclusion: Reassigning reference inside method doesn't affect original");
        System.out.println("Only the copy of reference is changed\n");
        
        System.out.println("4. MODIFYING ARRAYS:");
        int[] marksArray = {70, 75, 80, 85, 90};
        System.out.println("Before method call:");
        for (int i = 0; i < marksArray.length; i++) {
            System.out.println("marksArray[" + i + "] = " + marksArray[i]);
        }
        modifyArray(marksArray);
        System.out.println("After method call:");
        for (int i = 0; i < marksArray.length; i++) {
            System.out.println("marksArray[" + i + "] = " + marksArray[i]);
        }
        System.out.println("Conclusion: Array elements can be modified");
        System.out.println("Because array reference points to the same object\n");
    }
}
