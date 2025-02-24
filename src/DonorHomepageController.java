import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DonorHomepageController {
    //instance variable t keep track of the current user
    private Donor current;
    @FXML
    private Button logoutButton;

    @FXML
    private Button findOrgButton;

    @FXML
    private Button viewNeeds;

    @FXML
    private Button viewDonations;

    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
        Parent signupparent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene signUpScene = new Scene(signupparent);

        // Get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);
        window.show();
    }

    @FXML
    public void setFindOrgButton(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Browseorganisations.fxml"));
        Parent root = loader.load();
        BrowseNeeds controller = loader.getController();
        controller.setCurrent(this.current);
        Scene signUpScene = new Scene(root);

        // Get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);
        window.show();
    }

    @FXML
    public void setViewNeeds(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("browseNeeds.fxml"));
        Parent root = loader.load();
        BrowseNeeds controller = loader.getController();
        controller.setCurrent(this.current);
        Scene signUpScene = new Scene(root);

        // Get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);
        window.show();
    }

    public void setCurrent(Donor donor){
        this.current=donor;
    }

    @FXML
    public void setViewDonations(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewDonations.fxml"));
        Parent root = loader.load();
        ViewDonations controller = loader.getController();
        controller.setCurrent(current);
        Scene signUpScene = new Scene(root);

        // Get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);
        window.show();
    }


}
