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

public class AddNeedPage implements Initializable {
    private Organisation current;

    @FXML
    private Button backButton;

    @FXML
    private Button addButton;

    @FXML
    private ChoiceBox<String> categories;

    @FXML
    private TextArea description;

    @FXML
    private TextField contact;

    @FXML
    private Label feedbackLabel;

    String[] filters={"Food items","Clothing items","Cleaning Supplies","Medical Supplies","Learning material","Funds","Sports"};


    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("orgHome.fxml"));
        Parent root = loader.load();
        OrgHomeController controller = loader.getController();
        controller.setCurrent(current);
        Scene signUpScene = new Scene(root);

        // Get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categories.getItems().addAll(filters);
    }

    @FXML
    public void addButtonClicked(ActionEvent event) {
        String category=categories.getValue().toString();
        String descr=description.getText().trim();
        String cont=contact.getText().trim();

        if (category.isEmpty()||descr.isEmpty()||cont.isEmpty()){
            feedbackLabel.setText("Please fill in all required fields correctly");
            return;
        }
        Need newNeed=new Need(current.getId(), current.getFname(), category,descr,cont);
        current.addNeed(newNeed);
        feedbackLabel.setText("Need added Successfully!");
    }

    public void setCurrent(Organisation current){
        this.current=current;
    }
}
