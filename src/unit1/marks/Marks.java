package unit1.marks;

public class Marks {
    private int studentId;
    private String studentName;
    private int marks;
    
    public Marks(int studentId, String studentName, int marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks >= 0 ? marks : 0;
    }
    
    public int getStudentId() {
        return studentId;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public int getMarks() {
        return marks;
    }
    
    public void setMarks(int marks) {
        this.marks = marks >= 0 ? marks : 0;
    }
    
    public void displayMarks() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + studentName);
        System.out.println("Marks: " + marks);
        System.out.println("------------------------");
    }
    
    public char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 80) return 'B';
        else if (marks >= 70) return 'C';
        else if (marks >= 60) return 'D';
        else return 'F';
    }
}
