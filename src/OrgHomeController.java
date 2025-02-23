import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class OrgHomeController {
    private Organisation current;
    @FXML
    private Button addneedbutton;

    @FXML
    private Button logoutbutton;

    @FXML
    private Button allNeedsButton;

    @FXML
    private Button donationsbutton;

    @FXML
    private Label label;

    @FXML
    private void setAddneedbutton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("addNeedPage.fxml"));
        Parent root = loader.load();
        AddNeedPage controller = loader.getController();
        controller.setCurrent(current);
        Scene signUpScene = new Scene(root);

        // Get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);

    }

    @FXML
    private void setAllneedbutton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("orgNeeds.fxml"));
        Parent root = loader.load();
        OrgNeeds controller = loader.getController();
        controller.setCurrent(current);
        Scene signUpScene = new Scene(root);

        // Get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);

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

    public void setCurrent(Organisation current){
        this.current=current;
    }

    public void setDonationsbutton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("orgDonations.fxml"));
        Parent root = loader.load();
        OrgDonations controller = loader.getController();
        controller.setCurrent(current);
        Scene signUpScene = new Scene(root);

        // Get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);

    }

}
