package unit3.marks;

public class InvalidMarksException extends Exception {
    private final double marks;
    private final String subject;
    private final String studentName;
    private final double minValid;
    private final double maxValid;
    
    public InvalidMarksException(double marks, String subject, String studentName, double minValid, double maxValid) {
        super(String.format("Invalid marks %.2f for %s in %s. Valid range: %.1f to %.1f", 
                           marks, studentName, subject, minValid, maxValid));
        this.marks = marks;
        this.subject = subject;
        this.studentName = studentName;
        this.minValid = minValid;
        this.maxValid = maxValid;
    }
    
    public InvalidMarksException(double marks, String subject, String studentName, double minValid, double maxValid, String customMessage) {
        super(customMessage);
        this.marks = marks;
        this.subject = subject;
        this.studentName = studentName;
        this.minValid = minValid;
        this.maxValid = maxValid;
    }
    
    public double getMarks() {
        return marks;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public double getMinValid() {
        return minValid;
    }
    
    public double getMaxValid() {
        return maxValid;
    }
    
    public boolean isTooLow() {
        return marks < minValid;
    }
    
    public boolean isTooHigh() {
        return marks > maxValid;
    }
    
    public String getErrorMessage() {
        if (isTooLow()) {
            return String.format("Marks %.2f are below minimum (%.1f) for %s in %s", 
                               marks, minValid, studentName, subject);
        } else if (isTooHigh()) {
            return String.format("Marks %.2f are above maximum (%.1f) for %s in %s", 
                               marks, maxValid, studentName, subject);
        } else {
            return "Invalid marks value";
        }
    }
    
    public String getSuggestedAction() {
        if (isTooLow()) {
            return "Please verify the marks entry. Minimum allowed is " + minValid;
        } else if (isTooHigh()) {
            return "Please verify the marks entry. Maximum allowed is " + maxValid;
        } else {
            return "Please check marks entry for accuracy";
        }
    }
    
    @Override
    public String toString() {
        return String.format(
            "InvalidMarksException:\n" +
            "Student: %s\n" +
            "Subject: %s\n" +
            "Invalid Marks: %.2f\n" +
            "Valid Range: %.1f - %.1f\n" +
            "Error: %s\n" +
            "Suggestion: %s",
            studentName, subject, marks, minValid, maxValid, getErrorMessage(), getSuggestedAction()
        );
    }
}
