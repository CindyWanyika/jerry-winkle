import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ViewDonations implements Initializable {
    private Donor current;


    @FXML
    private Label nameLabel;

    @FXML
    private Label feedbackLabel;

    @FXML
    private Button backbutton;

    @FXML
    private ListView<String> listView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DonorHomepage.fxml"));
        Parent root = loader.load();
        DonorHomepageController controller = loader.getController();
        controller.setCurrent(current);
        Scene signUpScene = new Scene(root);

        // Get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);
        window.show();
    }
    public void setCurrent(Donor current){
        this.current=current;
        ArrayList<Donation> allDonations=current.getDonations();
        if (allDonations.isEmpty()){
            feedbackLabel.setText("You have not made any donations yet");

        }
        else{
            for(Donation donation:allDonations){
                listView.getItems().add(donation.toString());
            }
        }
    }
}
