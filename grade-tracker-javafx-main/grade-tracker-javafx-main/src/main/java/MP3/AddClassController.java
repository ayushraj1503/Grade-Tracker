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

public class AddClassController extends MainApp {
    @FXML
    private Label classLabel, teacherLabel;

    @FXML
    private TextField classField, teacherField;

    @FXML
    private Button cancelClassBtn, createClassBtn;

    public AddClassController() {

    }

    @FXML
    public void initialize() {

    }

    @FXML
    private void handleCreateClassBtn(ActionEvent event) {
        // Add Class to currentStudent
        String className = classField.getText().trim();
        String teacherName = teacherField.getText().trim();
        currentStudent.addClass(new Class(className, teacherName, 0, new ArrayList<Assignment>()));

        // Go back to Progress.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Progress.fxml"));
        Stage stage;
        Parent root;
        try {
            root = (Parent) loader.load();
            stage = (Stage) createClassBtn.getScene().getWindow();
            ProgressController controller = (ProgressController) loader.getController();
            stage.setTitle("Progress");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCancelClassBtn(ActionEvent event) {
        // Go back to Progress.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Progress.fxml"));
        Stage stage;
        Parent root;
        try {
            root = (Parent) loader.load();
            stage = (Stage) cancelClassBtn.getScene().getWindow();
            ProgressController controller = (ProgressController) loader.getController();
            stage.setTitle("Progress");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
