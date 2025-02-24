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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BrowseNeeds implements Initializable {
    private Donor current;

    @FXML
    private Button backButton;

    @FXML
    private Button donateButton;

    @FXML
    private ListView<Need> needsList;

    @FXML
    private Label feedbacklabel;

    @FXML
    private ChoiceBox<String> filter;

    String[] filters={"All","Food items","Clothing items","Cleaning Supplies","Medical Supplies","Learning material","Funds","Sports"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        filter.getItems().addAll(filters);
        filter.setValue("All");

        updateNeedsList();

        filter.setOnAction(event -> updateNeedsList());

        needsList.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(Need need, boolean empty) {
                super.updateItem(need, empty);
                setText(empty || need == null ? null : need.toString());
            }
        });

    }

    @FXML
    private void handleDonate() {
        Need selectedNeed = needsList.getSelectionModel().getSelectedItem();
        if (selectedNeed != null) {

            Organisation org = selectedNeed.getNeedOrg();

            feedbacklabel.setText(current.donate(org,selectedNeed));
            System.out.println("Donation created");

        }
    }


    private void updateNeedsList() {
        String fil = filter.getValue().toString();
        ArrayList<Need> needs = fil.equalsIgnoreCase("All") ? Need.getAllNeeds() : Donor.findNeeds(fil);


        needsList.getItems().clear();  // Clear old items before adding new ones
        if (needs != null) {
            for (Need need : needs) {
                needsList.getItems().add(need);
            }
        }
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

    public void setCurrent(Donor donor){
        this.current=donor;
    }

}
