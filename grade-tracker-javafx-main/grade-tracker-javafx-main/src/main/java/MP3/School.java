package MP3;

import java.util.ArrayList;

public class School {
    private ArrayList<Student> students = new ArrayList<Student>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(String email, String password) {
        for (Student s : students) {
            if (s.getEmail().equals(email) && s.getPassword().equals(password))
                return s;
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
