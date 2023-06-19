package MP3;

import java.util.ArrayList;
import java.util.UUID;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    // The school
    protected static School school;

    // Student's information to be displayed
    protected static Student currentStudent;

    // Index of selected class
    protected int selectedClassIdx;

    // UUID of selected class
    protected static UUID selectedClassId;

    public static void main(String[] args) {
        // Use a JSONParser to load school with students
        school = new School();

        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        assignments.add(new Assignment("Homework", 100));
        assignments.add(new Assignment("Classwork", 80));
        Class calc = new Class("AP Calculus BC", "Teacher", 100, assignments);
        Class eng = new Class("Film and Literature", "Teacher", 100, assignments);
        Class compSci = new Class("AP Computer Science A", "Teacher", 100, assignments);
        ArrayList<Class> classes = new ArrayList<Class>();
        classes.add(calc);
        classes.add(eng);
        classes.add(compSci);
        Student s = new Student("John", "", "Doe", "04/29/2003", UUID.randomUUID(), "8888 88St City 888888 NY",
                "8888888888", "Male", "example@email.com", "password", classes);
        school.addStudent(s);
        currentStudent = s;

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Signup.fxml"));
        Parent root;
        try {
            root = (Parent) loader.load();
            SignupController controller = (SignupController) loader.getController();
            stage.setTitle("Signup");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
