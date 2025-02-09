package com.thomas.streamintjenestekopi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserMenuController {
    UseCase useCase = new UseCase();
    private Stage stage;
    private Scene scene;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    public void goToMainMenu() {
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    TextArea textArea = new TextArea();

    @FXML
    TextField firstNameTextField = new TextField();

    @FXML
    TextField lastNameTextField = new TextField();

    @FXML
    TextField emailTextField = new TextField();

    @FXML
    TextField subscriptionTypeTextField = new TextField();

    public void onOKButtonClicked(ActionEvent actionEvent) {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String email = emailTextField.getText();
        String subscriptionType = subscriptionTypeTextField.getText();
        String added = useCase.addUser(1, firstName, lastName, email, subscriptionType);
        textArea.setText(added);
        textArea.appendText("\n" + firstName + " " + lastName + " " + email + " " + subscriptionType + "\n");

    }
}
