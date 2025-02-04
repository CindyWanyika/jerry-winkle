import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class OrgHomeController {
    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private void buttonClicked(ActionEvent event){
        label.setText("You clicked the button");
    }
}
