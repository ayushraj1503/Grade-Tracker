package MP3;

import java.util.ArrayList;
import java.util.UUID;

public class Student {
    private String firstName;
    private String middleName;
    private String lastName;
    private String DOB;
    private UUID id;
    private String address;
    private String phoneNumber;
    private String gender;
    private String email;
    private String password;
    private ArrayList<Class> classes;

    public Student(String firstName, String middleName, String lastName, String DOB, UUID id, String address,
            String phoneNumber, String gender, String email, String password, ArrayList<Class> classes) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.classes = classes;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public UUID getId() {
        return id;
    }

    public String getDOB() {
        return DOB;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void addClass(Class c) {
        this.classes.add(c);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }
}
