package unit2.college;

public class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age >= 0 ? age : 0;
        System.out.println("Person constructor called: " + name + ", " + age);
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age >= 0 ? age : 0;
    }
    
    public void displayPersonInfo() {
        System.out.println("Person Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    
    public void introduce() {
        System.out.println("Hello, I am " + name + " and I am " + age + " years old.");
    }
}
