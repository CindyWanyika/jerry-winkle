import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BrowseNeeds implements Initializable {
    private Donor current;

    @FXML
    private Button backButton;

    @FXML
    private Button donatebutton;

    @FXML
    private ListView needsList;

    @FXML
    private ChoiceBox filter;

    String[] filters={"All","Food items","Clothing items","Cleaning Supplies","Medical Supplies","Learning material","Funds","Sports"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        filter.getItems().addAll(filters);
        filter.setValue("All");

        updateNeedsList();

        filter.setOnAction(event -> updateNeedsList());
    }


    private void updateNeedsList() {
        String fil = filter.getValue().toString();
        ArrayList<Need> needs = fil.equalsIgnoreCase("All") ? Need.getAllNeeds() : Donor.findNeeds(fil);

        needsList.getItems().clear();  // Clear old items before adding new ones
        if (needs != null) {
            for (Need need : needs) {
                needsList.getItems().add(need.toString());
            }
        }
    }
    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
        Parent signupparent = FXMLLoader.load(getClass().getResource("DonorHomepage.fxml"));
        Scene signUpScene = new Scene(signupparent);

        // Get stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(signUpScene);
        window.show();
    }

    public void setCurrent(Donor donor){
        this.current=current;
    }

}
