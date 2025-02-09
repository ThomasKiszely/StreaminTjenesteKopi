package com.thomas.streamintjenestekopi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("UserMenuView.fxml"));
        Scene scene2 = new Scene(fxmlLoader2.load());

        MainController controller = fxmlLoader.getController();
        UserMenuController userMenuController = fxmlLoader2.getController();

        controller.setStage(stage);
        userMenuController.setStage(stage);

        controller.setScene(scene2);
        userMenuController.setScene(scene);


        stage.setTitle("StreamingPlatform");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {

        launch(args);
    }

}
