/*import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CKonektApp extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        // Root pane
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: Blue;");  // Dark background

        // Welcome message
        Text welcomeText = new Text("Welcome to CharityKonnekt");
        welcomeText.setFont(Font.font("Aria", 30));
        welcomeText.setFill(Color.BLACK);

        Text taglineText = new Text("Connecting you to charities you care about");
        taglineText.setFont(Font.font("Aria", 10));
        taglineText.setFill(Color.PURPLE);

        // VBox for login and account creation options
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: white;");

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-font-size: 20px; -fx-background-color: purple; -fx-text-fill: white;");

        Button createAccountButton = new Button("Create Account");
        createAccountButton.setStyle("-fx-font-size: 20px; -fx-background-color: purple; -fx-text-fill: white;");

        vbox.getChildren().addAll(welcomeText, taglineText,loginButton, createAccountButton);

        root.getChildren().add(vbox);

        // Scene
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("CKonekt");
        stage.setScene(scene);
        stage.show();

        // Login Button Action
        loginButton.setOnAction(e -> openLoginPage(stage));

        // Create Account Button Action
        createAccountButton.setOnAction(e -> openCreateAccountPage(stage));
    }
    // Open Create Account page
    private void openCreateAccountPage(Stage stage) {
        VBox createAccountVBox = new VBox(20);
        createAccountVBox.setAlignment(Pos.CENTER);
        createAccountVBox.setStyle("-fx-background-color: white;");

        Text createAccountTitle = new Text("Create Account");
        createAccountTitle.setFont(Font.font("Arial", 30));
        createAccountTitle.setFill(Color.MEDIUMPURPLE);

        TextField firstnameField = new TextField();
        firstnameField.setPromptText("First name");
        TextField lastnameField = new TextField();
        lastnameField.setPromptText("Last name");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm Password");
        TextField countryField = new TextField();
        countryField.setPromptText("Country");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("Donor", "Organisation");
        typeComboBox.setPromptText("Select Account Type");

        Button createAccountButton = new Button("Create Account");
        createAccountButton.setStyle("-fx-font-size: 20px; -fx-background-color: mediumpurple; -fx-text-fill: white;");

        Button backButton=new Button("back to login");
        backButton.setStyle("-fx-font-size: 20px; -fx-background-color: mediumPurple; -fx-text-fill: white;");

        Label feedbackLabel = new Label();
        feedbackLabel.setFont(Font.font("Arial", 16));
        feedbackLabel.setTextFill(Color.RED);


        createAccountVBox.getChildren().addAll(createAccountTitle, firstnameField,lastnameField, passwordField, confirmPasswordField,countryField,emailField, typeComboBox, createAccountButton,feedbackLabel,backButton);

        Scene createAccountScene = new Scene(createAccountVBox, 500, 600);
        stage.setScene(createAccountScene);

        createAccountButton.setOnAction(e -> {
            String fname = firstnameField.getText().trim();
            String lname = lastnameField.getText().trim();
            String password = passwordField.getText().trim();
            String confirmPassword = confirmPasswordField.getText().trim();
            String type = typeComboBox.getValue();
            String country = countryField.getText().trim();
            String email = emailField.getText().trim();

            // Clear feedback label
            feedbackLabel.setText("");

            // Check if all fields are filled
            if (fname.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || type == null|| country.isEmpty()||lname.isEmpty()||email.isEmpty()) {
                feedbackLabel.setText("Error: All fields must be filled.");
                feedbackLabel.setTextFill(Color.RED);
                return;
            }

            // Check if passwords match
            if (!password.equals(confirmPassword)) {
                feedbackLabel.setText("Error: Passwords do not match.");
                feedbackLabel.setTextFill(Color.RED);
                return;
            }


            User.createAccount(fname,lname,password,type,country,email);

            // Provide success feedback
            feedbackLabel.setText("Account created successfully.");
            feedbackLabel.setTextFill(Color.GREEN);
            System.out.println("Account created successfully.");
        });

        backButton.setOnAction(e-> {
            try {
                start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    // Open Login page
    private void openLoginPage(Stage stage) {
        // Create the main layout for the login page
        VBox loginVBox = new VBox(20);
        loginVBox.setAlignment(Pos.CENTER);
        loginVBox.setStyle("-fx-background-color: white;");

        // Create and style title
        Text loginTitle = new Text("Login");
        loginTitle.setFont(Font.font("Arial", 30));
        loginTitle.setFill(Color.PURPLE);

        // Create input fields for username and password
        TextField usernameField = new TextField();
        usernameField.setPromptText("Name");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        // Create the login button
        Button loginSubmitButton = new Button("Login");
        loginSubmitButton.setStyle("-fx-font-size: 20px; -fx-background-color: purple; -fx-text-fill: white;");

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-font-size: 10px; -fx-background-color: purple; -fx-text-fill: white;");

        // Label for feedback messages
        Label feedbackLabel = new Label();
        feedbackLabel.setFont(Font.font("Arial", 16));
        feedbackLabel.setTextFill(Color.RED);

        // Back button action (return to home or previous screen)
        backButton.setOnAction(e -> {
            try {
                start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        // Add components to the layout
        loginVBox.getChildren().addAll(loginTitle, usernameField,emailField, passwordField, loginSubmitButton, feedbackLabel, backButton);

        Scene loginScene = new Scene(loginVBox, 400, 400);
        stage.setScene(loginScene);

        // Login Button Action
        loginSubmitButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String email=emailField.getText();

            // ensure valid inputs
            if (username.isEmpty() || password.isEmpty()||email.isEmpty()) {
                feedbackLabel.setText("Enter all fields");
                feedbackLabel.setTextFill(Color.RED);
                return;
            }

            User user=User.login(username,email,password);
            if (!user.equals(null)) {
                feedbackLabel.setText("Login successful!");
                feedbackLabel.setTextFill(Color.GREEN);  // Success message in green
                System.out.println("Login successful!");

                // Retrieve the user's role and proceed accordingly
            } else {
                feedbackLabel.setText("Invalid credentials. Try again.");
                feedbackLabel.setTextFill(Color.RED);  // Show error in red color
                System.out.println("Invalid credentials. Try again.");
            }
        });


    }
}*/
