import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    private TextField password;
    @FXML
    private TextField pword;
    @FXML
    private Button signUpButton;
    @FXML
    private Button backButton;

    @FXML
    private TextField licenceNo; // Licence No field (initially hidden)
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
        String descriptionText = description.isVisible() ? description.getText().trim() : ""; // Only get the description if it's visible

        // Perform validation
        if (validateFields(name, lnameText, passwordText, confirmPassword, type, countryText)) {
            try {
                // Provide feedback to user (initially clear)
                feedbackLabel.setText("");

                // Proceed to create account based on account type
                if (type.equals("Organisation")) {
                    // Call the createOrg method for Organisation type
                    Organisation.createOrg(id,name, lnameText, passwordText, type, countryText, emailAddress, licence, descriptionText);
                    feedbackLabel.setText("Account created successfully!");
                } else {
                    // Create a donor account (you can handle donor creation here)
                    createAccount(name, lnameText, passwordText, type, countryText, emailAddress);
                    feedbackLabel.setText("Account created successfully!");
                }
            } catch (Exception e) {
                feedbackLabel.setText("Error: " + e.getMessage());
            }
        } else {
            // Handle incomplete or invalid input
            feedbackLabel.setText("Please fill in all required fields correctly.");
        }
    }

    // Validate user input before calling createAccount
    private boolean validateFields(String name, String lname, String password, String confirmPassword, String type, String country) {
        if (name.isEmpty() || lname.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || type == null || country.isEmpty()) {
            return false;
        }
        if (!password.equals(confirmPassword)) {
            return false;
        }
        return true;
    }


    public static void createAccount(String name, String lname, String pword, String type, String country, String emailAddress) throws Exception {

        if (name.isEmpty() || lname.isEmpty() || pword.isEmpty() || type == null || country.isEmpty()) {
            throw new Exception("Some required fields are missing.");
        }

        System.out.println("Account created successfully for " + name + " " + lname);
    }



    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    public void handleBackButton(ActionEvent event) {
        System.out.println("Back to login clicked.");
        // Logic to switch to login screen, e.g., navigate back to a login FXML
    }
}