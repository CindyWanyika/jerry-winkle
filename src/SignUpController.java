import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private TextField fname;
    @FXML
    private TextField lname;

    @FXML
    private TextField emailField;
    @FXML
    private TextField country;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField pword;
    @FXML
    private Button signUpButton;
    @FXML
    private Button backButton;

    @FXML
    private TextField licenceNo;
    @FXML
    private TextArea description; // Description field (initially hidden)
    @FXML
    private Label feedbackLabel; // Label for feedback messages
    private static int id=User.idCount;
    @FXML
    private ComboBox<String> accountType;
    private String[] types={"donor","Organisation"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountType.getItems().addAll(types);
        accountType.setOnAction(event -> handleAccountTypeChange());
    }

    // Method to handle changes in the account type selection
    private void handleAccountTypeChange() {
        if (accountType.getValue().equals("Organisation")) {
            licenceNo.setVisible(true);
            description.setVisible(true);
            lname.setVisible(false);
        } else {
            licenceNo.setVisible(false);
            description.setVisible(false);
        }
    }

    // Sign Up button handler
    @FXML
    public void handleSignUpButton(ActionEvent event) {
        String name = fname.getText().trim();
        String lnameText = lname.getText().trim();
        String passwordText = password.getText().trim();
        String confirmPassword = pword.getText().trim();
        String type = accountType.getValue();
        String countryText = country.getText().trim();
        String emailAddress = emailField.getText().trim(); // Get the email
        String licence = licenceNo.isVisible() ? licenceNo.getText().trim() : ""; // Only get the licence number if it's visible
        String descriptionText = description.isVisible() ? description.getText().trim() : "";

        if (name.isEmpty() || passwordText.isEmpty() || confirmPassword.isEmpty() || type == null || countryText.isEmpty()) {
            feedbackLabel.setText("Please fill in all required fields correctly.");
            return;
        }
        if (!passwordText.equals(confirmPassword)) {
            feedbackLabel.setText("Passwords must match");
            return;
        }
        if (User.userExists(emailAddress)){
            feedbackLabel.setText("Account with that email already exists");
            return;
        }
        User.createAccount(name, lnameText, passwordText, type, countryText, emailAddress);
        feedbackLabel.setText("Account created successfully!");


        if (type.equals("Organisation")) {

            Organisation.createOrg(id,name, passwordText, type, countryText, emailAddress, licence, descriptionText);
        }

    }


    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
        Parent signupparent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene signUpScene = new Scene(signupparent);

        // Get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);
        window.show();
    }
}