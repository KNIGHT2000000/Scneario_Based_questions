package unit2.college;

public class CollegeSystemDemo {
    public static void main(String[] args) {
        System.out.println("=== College System Demo ===\n");
        
        System.out.println("=== Constructor Chain Demonstration ===\n");
        
        Person person = new Person("John Smith", 45);
        System.out.println();
        
        Teacher teacher = new Teacher("Alice Johnson", 35, "Mathematics", 60000.0);
        System.out.println();
        
        HOD hod = new HOD("Robert Davis", 50, "Physics", 80000.0, "Science", 20);
        System.out.println();
        
        System.out.println("=== Displaying All Information ===\n");
        
        System.out.println("Person Details:");
        person.displayPersonInfo();
        person.introduce();
        System.out.println();
        
        System.out.println("Teacher Details:");
        teacher.displayPersonInfo();
        teacher.introduce();
        teacher.teach();
        teacher.gradePapers();
        System.out.println();
        
        System.out.println("HOD Details:");
        hod.displayPersonInfo();
        hod.introduce();
        hod.teach();
        hod.manageDepartment();
        hod.conductMeeting();
        hod.approveBudget();
        System.out.println();
        
        System.out.println("=== Super Constructor Chain Explanation ===");
        System.out.println("1. Person(name, age) - Base class constructor");
        System.out.println("2. Teacher(name, age, subject, salary) - Calls super(name, age)");
        System.out.println("3. HOD(name, age, subject, salary, department, experience) - Calls super(...)");
        System.out.println();
        
        System.out.println("Constructor Execution Order:");
        System.out.println("- When creating HOD: Person -> Teacher -> HOD");
        System.out.println("- Each constructor initializes its own properties");
        System.out.println("- super() calls parent constructor");
        System.out.println("- this() would call same class constructor");
        System.out.println();
        
        System.out.println("=== Inheritance Hierarchy ===");
        System.out.println("Person (Base Class)");
        System.out.println("  ├── name, age");
        System.out.println("  ├── displayPersonInfo()");
        System.out.println("  └── introduce()");
        System.out.println();
        System.out.println("Teacher (Derived from Person)");
        System.out.println("  ├── subject, salary");
        System.out.println("  ├── teach(), gradePapers()");
        System.out.println("  └── Overrides displayPersonInfo(), introduce()");
        System.out.println();
        System.out.println("HOD (Derived from Teacher)");
        System.out.println("  ├── department, yearsOfExperience");
        System.out.println("  ├── manageDepartment(), conductMeeting(), approveBudget()");
        System.out.println("  └── Overrides displayPersonInfo(), introduce(), teach()");
        
        System.out.println("\n=== Data Flow Through Constructors ===");
        System.out.println("name: Person -> Teacher -> HOD");
        System.out.println("age: Person -> Teacher -> HOD");
        System.out.println("subject: Teacher -> HOD");
        System.out.println("salary: Teacher -> HOD");
        System.out.println("department: HOD only");
        System.out.println("experience: HOD only");
    }
}
