package MP3;

import java.util.ArrayList;
import java.util.UUID;

public class Class {
    private UUID id;
    private String name;
    private String teacher;
    private double grade;
    private ArrayList<Assignment> assignments;

    public Class(String name, String teacher, double grade, ArrayList<Assignment> assignments) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.teacher = teacher;
        this.grade = grade;
        this.assignments = assignments;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public double getGrade() {
        return grade;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }
}
