package unit1.college;

public class Student {
    private static String collegeName = "ABC University";
    private static int totalStudents = 0;
    
    private int rollNumber;
    private String name;
    private String department;
    private double marks;
    
    public Student(int rollNumber, String name, String department, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.department = department;
        this.marks = marks >= 0 ? marks : 0.0;
        totalStudents++;
    }
    
    public static String getCollegeName() {
        return collegeName;
    }
    
    public static void setCollegeName(String collegeName) {
        Student.collegeName = collegeName;
    }
    
    public static int getTotalStudents() {
        return totalStudents;
    }
    
    public int getRollNumber() {
        return rollNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public double getMarks() {
        return marks;
    }
    
    public void setMarks(double marks) {
        this.marks = marks >= 0 ? marks : 0.0;
    }
    
    public void displayStudentInfo() {
        System.out.println("Student Information:");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Marks: " + marks);
        displayCollegeInfo();
        System.out.println("------------------------");
    }
    
    public static void displayCollegeInfo() {
        System.out.println("College: " + collegeName);
        System.out.println("Total Students: " + totalStudents);
    }
    
    public char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 80) return 'B';
        else if (marks >= 70) return 'C';
        else if (marks >= 60) return 'D';
        else return 'F';
    }
    
    public void displayAcademicInfo() {
        System.out.println("Academic Information for " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
        System.out.println("Status: " + (marks >= 60 ? "Pass" : "Fail"));
    }
}
