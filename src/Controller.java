import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {

    @FXML
    public void signupButton1clicked(ActionEvent event) throws IOException {
        Parent signupparent = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        Scene signUpScene = new Scene(signupparent);

        // Get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);
        window.show();
    }
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField nameField;
    @FXML
    public void loginButtonClicked(ActionEvent event) throws IOException {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText().trim();

        // Check if fields are empty
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showAlert("Login Failed", "All fields must be filled out.");
            return;
        }


        User user = User.login(name, email, password);

        if (user == null) {
            showAlert("Login Failed", "Invalid credentials. Please try again.");
        } else {
            String role = user.getAccountType().toLowerCase();

            String fxmlFile;
            if (role.equals("donor")) {
                fxmlFile = "donorHomepage.fxml";
            } else if (role.equals("organization")) {
                fxmlFile = "orgHome.fxml";  // Change to your actual organization homepage file
            } else {
                showAlert("Login Error", "Unrecognized user role.");
                return;
            }


            switchScene(event, fxmlFile);
        }
    }

    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

