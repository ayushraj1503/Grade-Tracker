package MP3;

import java.util.UUID;

public class Assignment {
    private UUID id;
    private String name;
    private double grade;

    public Assignment(String name, double grade) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.grade = grade;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
