package MP3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignupController extends MainApp {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField middleNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button signUpBtn, logInBtn;
    @FXML
    private Text actionText;

    public SignupController() {
        System.out.println("Signup Page Loaded");
    }

    @FXML
    public void initialize() {
        firstNameField.setPromptText("Enter your First Name");
        middleNameField.setPromptText("Enter your Middle Name");
        lastNameField.setPromptText("Enter your Last Name");
        birthdayField.setPromptText("mm/dd/yyyy");
        genderField.setPromptText("Enter your gender");
        addressField.setPromptText("Enter your address");
        phoneNumberField.setPromptText("8888888888");
        emailField.setPromptText("example@email.com");
        passwordField.setPromptText("Enter your password");
    }

    @FXML
    public String getErrors() {
        String errorText = "";

        if (firstNameField.getText().trim().equals(""))
            errorText += "Please enter a valid First Name\n";
        // Middle Name can be empty
        if (lastNameField.getText().trim().equals(""))
            errorText += "Please enter a valid Last Name\n";
        if (!Validators.isValidDOB(birthdayField.getText().trim()))
            errorText += "Please enter a valid Birthday\n";
        // Gender can be empty
        // Address can be empty
        if (!Validators.isValidPhoneNumber(phoneNumberField.getText().trim()))
            errorText += "Please enter a valid Phone Number\n";
        if (!Validators.isValidEmail(emailField.getText().trim()))
            errorText += "Please enter a valid Email\n";
        if (passwordField.getText().trim().equals(""))
            errorText += "Please enter a non-empty Password\n";

        return errorText;
    }

    @FXML
    private void handleSignUpBtn(ActionEvent event) {
        // if (getErrors().equals("")) {
        // Create User account
        // String fN = firstNameField.getText().trim();
        // String mN = middleNameField.getText().trim();
        // String lN = lastNameField.getText().trim();
        // String dob = birthdayField.getText().trim();
        // UUID id = UUID.randomUUID();
        // String address = addressField.getText().trim();
        // String phoneNumber = phoneNumberField.getText().trim();
        // String gender = genderField.getText().trim();
        // String email = emailField.getText().trim();
        // String password = passwordField.getText();

        // Student s = new Student(fN, mN, lN, dob, id, address, phoneNumber, gender,
        // email, password,
        // new ArrayList<Class>());

        // school.addStudent(s);

        // currentStudent = s;

        // Load Progress.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Progress.fxml"));
        Stage stage;
        Parent root;

        try {
            root = (Parent) loader.load();
            ProgressController controller = (ProgressController) loader.getController();
            stage = (Stage) signUpBtn.getScene().getWindow();
            stage.setTitle("Progress");
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // } else {
        // actionText.setText(getErrors());
        // }
    }

    @FXML
    private void handleLogInBtn(ActionEvent event) {
    }
}