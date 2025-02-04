import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import javafx.event.ActionEvent;

import java.io.IOException;

public class Sample extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Charity konekt");
        stage.setScene(new Scene(root,700,400));
        stage.show();


    }


}