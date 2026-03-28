package unit2.hospitaladvanced;

public abstract class Person {
    protected String name;
    protected int age;
    protected String gender;
    protected String address;
    protected String phoneNumber;
    
    public Person(String name, int age, String gender, String address, String phoneNumber) {
        this.name = name;
        this.age = age >= 0 ? age : 0;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    // Setters
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    // Abstract methods
    public abstract String getRole();
    public abstract void displayDetails();
    
    // Concrete method
    public void updateContactInfo(String address, String phoneNumber) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        System.out.println("Contact information updated for " + name);
    }
    
    // Concrete method
    public void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phoneNumber);
    }
}
