package MP3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgressController extends MainApp {

    @FXML
    private ListView<HBox> listView, studentAssignmentsListView;

    @FXML
    private Label studentName, studentId, studentDOB, studentGender, studentAddress, studentPhoneNumber, studentEmail,
            currentClass, currentTeacher;

    @FXML
    private Button inspectClassBtn, addClassBtn, addAssignmentBtn;

    @FXML
    private VBox rightContainer;

    public ProgressController() {
        System.out.println("Progress Page Loaded");
    }

    @FXML
    public void initialize() {
        rightContainer.setMinWidth(200);

        // Populate List View
        for (Class c : currentStudent.getClasses()) {
            HBox h = new HBox();
            Region r = new Region();
            HBox.setHgrow(r, Priority.ALWAYS);
            h.getChildren().addAll(new Label(c.getName()), r, new Label(c.getGrade() + ""));
            listView.getItems().add(h);
        }

        // Populate Student Bio
        studentName.setText(studentName.getText() + currentStudent.getFirstName() + " " + currentStudent.getMiddleName()
                + " " + currentStudent.getLastName());
        studentId.setText(studentId.getText() + currentStudent.getId().toString());
        studentDOB.setText(studentDOB.getText() + currentStudent.getDOB());
        studentGender.setText(studentGender.getText() + currentStudent.getGender());
        studentAddress.setText(studentAddress.getText() + currentStudent.getAddress());
        studentPhoneNumber.setText(studentPhoneNumber.getText() + "(" + currentStudent.getPhoneNumber().substring(0, 3)
                + ")" + currentStudent.getPhoneNumber().substring(3, 6) + "-"
                + currentStudent.getPhoneNumber().substring(6));
        studentEmail.setText(studentEmail.getText() + currentStudent.getEmail());

        // Populate Assignmens
        populateAssignments();

        // List View Listener
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<HBox>() {

            @Override
            public void changed(ObservableValue<? extends HBox> observable, HBox oldValue, HBox newValue) {
                populateAssignments();
            }
        });
    }

    @FXML
    private void populateAssignments() {
        ObservableList<Integer> selectedIndices = listView.getSelectionModel().getSelectedIndices();

        // Get index of selected item in list
        for (Object i : selectedIndices) {
            selectedClassIdx = (int) i;
        }

        Class selectedClass = currentStudent.getClasses().get(selectedClassIdx);
        selectedClassId = selectedClass.getId();

        System.out.println(selectedClassId);

        currentClass.setText(selectedClass.getName());
        currentTeacher.setText(selectedClass.getTeacher());

        // Clear assignments
        studentAssignmentsListView.getItems().clear();

        // Populate assignments
        for (Assignment a : selectedClass.getAssignments()) {
            HBox h = new HBox();
            Region r = new Region();
            HBox.setHgrow(r, Priority.ALWAYS);
            Label name = new Label(a.getName());
            Label grade = new Label(a.getGrade() + "");

            h.getChildren().addAll(name, r, grade);

            studentAssignmentsListView.getItems().add(h);
        }
    }

    @FXML
    private void handleAddClassBtn(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddClass.fxml"));
        Stage stage;
        Parent root;

        try {
            root = (Parent) loader.load();
            AddClassController controller = (AddClassController) loader.getController();
            stage = (Stage) addClassBtn.getScene().getWindow();
            stage.setTitle("Add Class");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddAssignmentBtn(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddAssignment.fxml"));
        Stage stage;
        Parent root;

        try {
            root = (Parent) loader.load();
            AddAssignmentController controller = (AddAssignmentController) loader.getController();
            stage = (Stage) addAssignmentBtn.getScene().getWindow();
            stage.setTitle("Add Assignment");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}