package MP3;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddAssignmentController extends MainApp {

    @FXML
    private Label assignmentLabel, gradeLabel;

    @FXML
    private TextField assignmentField, gradeField;

    @FXML
    private Button cancelAssignmentBtn, createAssignmentBtn;

    public AddAssignmentController() {

    }

    @FXML
    public void initialize() {
        // Set placeholders
        assignmentField.setPromptText("Enter name of assignment");
        gradeField.setPromptText("Enter assignment grade");
    }

    @FXML
    private void handleCreateAssignmentBtn(ActionEvent event) {
        System.out.println("current idx is: " + selectedClassIdx + "");

        // Add Assignment to selectedClass currentStudent
        String assignmentName = assignmentField.getText().trim();
        String grade = gradeField.getText().trim();

        // ArrayList<Class> newClasses = currentStudent.getClasses();
        // ArrayList<Assignment> newAssignments =
        // newClasses.get(selectedClassIdx).getAssignments();
        // newAssignments.add(new Assignment(assignmentName,
        // Double.parseDouble(grade)));

        // for (Class c : currentStudent.getClasses()) {
        // for (Assignment a : c.getAssignments()) {
        // System.out.println(c.getName() + ": " + a.getName());
        // }
        // }

        // System.out.println("----------------------------");

        // newClasses.set(selectedClassIdx,
        // new Class(currentStudent.getClasses().get(selectedClassIdx).getName(),
        // currentStudent.getClasses().get(selectedClassIdx).getTeacher(),
        // currentStudent.getClasses().get(selectedClassIdx).getGrade(),
        // newAssignments));

        // currentStudent.setClasses(newClasses);

        for (int i = 0; i < currentStudent.getClasses().size(); i++) {
            String classId = currentStudent.getClasses().get(i).getId().toString();
            if (classId.equals(selectedClassId.toString())) {
                System.out.println("Found: " + classId);
                ArrayList<Class> newClasses = currentStudent.getClasses();
                ArrayList<Assignment> newAssignments = currentStudent.getClasses().get(i).getAssignments();
                newAssignments.add(new Assignment(assignmentName, Double.parseDouble(grade)));
                newClasses.set(i,
                        new Class(currentStudent.getClasses().get(i).getName(),
                                currentStudent.getClasses().get(i).getTeacher(),
                                currentStudent.getClasses().get(i).getGrade(), newAssignments));
                currentStudent.setClasses(newClasses);
            }
        }

        for (Class c : currentStudent.getClasses()) {
            for (Assignment a : c.getAssignments()) {
                System.out.println(c.getName() + ": " + a.getName());
            }
        }

        // Go back to Progress.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Progress.fxml"));
        Stage stage;
        Parent root;
        try {
            root = (Parent) loader.load();
            stage = (Stage) createAssignmentBtn.getScene().getWindow();
            ProgressController controller = (ProgressController) loader.getController();
            stage.setTitle("Progress");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCancelAssignmentBtn(ActionEvent event) {
        // Go back to Progress.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Progress.fxml"));
        Stage stage;
        Parent root;
        try {
            root = (Parent) loader.load();
            stage = (Stage) cancelAssignmentBtn.getScene().getWindow();
            ProgressController controller = (ProgressController) loader.getController();
            stage.setTitle("Progress");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
