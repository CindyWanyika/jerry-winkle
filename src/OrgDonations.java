import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrgDonations implements Initializable {
    private Organisation current;

    @FXML
    private Button back;

    @FXML
    private ListView allDonations;


    public void setCurrent(Organisation current){
        this.current=current;

        ArrayList<Donation> donations = current.viewDonations();
        allDonations.getItems().clear();  // Clear any old data before adding new ones
        for (Donation donation : donations) {
            allDonations.getItems().add(donation.toString());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

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
}
