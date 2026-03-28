package unit1.college;

public class CollegeAdmissionDemo {
    public static void main(String[] args) {
        System.out.println("=== College Admission System Demo ===\n");
        
        System.out.println("=== Static vs Instance Members Demonstration ===\n");
        
        Student student1 = new Student(1001, "Alice Johnson", "Computer Science", 85.5);
        Student student2 = new Student(1002, "Bob Smith", "Electrical Engineering", 92.0);
        Student student3 = new Student(1003, "Carol Davis", "Mechanical Engineering", 78.5);
        Student student4 = new Student(1004, "David Wilson", "Civil Engineering", 88.0);
        Student student5 = new Student(1005, "Eva Brown", "Information Technology", 95.5);
        
        System.out.println("=== Individual Student Information ===\n");
        
        student1.displayStudentInfo();
        student2.displayStudentInfo();
        student3.displayStudentInfo();
        student4.displayStudentInfo();
        student5.displayStudentInfo();
        
        System.out.println("=== Static Methods and Variables ===\n");
        
        System.out.println("College Information (Static):");
        Student.displayCollegeInfo();
        System.out.println();
        
        System.out.println("Demonstrating static variable sharing:");
        System.out.println("College name from student1: " + student1.getCollegeName());
        System.out.println("College name from student2: " + student2.getCollegeName());
        System.out.println("College name from static method: " + Student.getCollegeName());
        System.out.println();
        
        System.out.println("Before changing college name:");
        System.out.println("College: " + Student.getCollegeName());
        
        Student.setCollegeName("XYZ Technical Institute");
        
        System.out.println("After changing college name:");
        System.out.println("College: " + Student.getCollegeName());
        System.out.println("College name from student1: " + student1.getCollegeName());
        System.out.println("College name from student3: " + student3.getCollegeName());
        System.out.println();
        
        System.out.println("=== Instance Methods ===\n");
        
        System.out.println("Academic Information (Instance Methods):");
        student1.displayAcademicInfo();
        System.out.println();
        student2.displayAcademicInfo();
        System.out.println();
        student3.displayAcademicInfo();
        System.out.println();
        
        System.out.println("=== Static vs Instance Comparison ===");
        System.out.println("Static Members:");
        System.out.println("- Shared among all objects");
        System.out.println("- Belong to the class, not to individual objects");
        System.out.println("- Accessed using class name or object reference");
        System.out.println("- Single copy exists for the entire class");
        System.out.println();
        
        System.out.println("Instance Members:");
        System.out.println("- Unique to each object");
        System.out.println("- Belong to individual objects");
        System.out.println("- Accessed only through object reference");
        System.out.println("- Each object has its own copy");
        System.out.println();
        
        System.out.println("=== Final Statistics ===");
        System.out.println("Total students admitted: " + Student.getTotalStudents());
        System.out.println("College: " + Student.getCollegeName());
        
        double totalMarks = student1.getMarks() + student2.getMarks() + student3.getMarks() + 
                          student4.getMarks() + student5.getMarks();
        double averageMarks = totalMarks / Student.getTotalStudents();
        System.out.println("Average marks: " + averageMarks);
    }
}
