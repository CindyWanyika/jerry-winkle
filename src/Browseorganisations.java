import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Browseorganisations implements Initializable {
    private ListView<String> listView;

    ArrayList<Organisation> allOrgs=Organisation.viewAllOrgs();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Organisation org:allOrgs){
            listView.getItems().add(org.toString());
        }

    }
}
