package co.edu.univalle.poe.mvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CrapsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CrapsApplication.class.getResource("view/craps-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("A jugar Craps!!");
        stage.setScene(scene);
        stage.show();
    }
}
