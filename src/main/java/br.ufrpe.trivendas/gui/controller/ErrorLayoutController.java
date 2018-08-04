package br.ufrpe.trivendas.gui.controller;

import br.ufrpe.trivendas.gui.model.GuiApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

public class ErrorLayoutController implements Serializable {
    @FXML
    Button okCloseButton;
    @FXML private static BorderPane errorRootLayout = new BorderPane();
    @FXML private Stage primaryErrorStage = new Stage();

    public void closeWindow(ActionEvent event){

    }

    public void initErrorRootLayout()
    {
        primaryErrorStage = new javafx.stage.Stage();
        primaryErrorStage.setTitle("Error Occurrence");

        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/RootErrorLayout.fxml"));
            errorRootLayout = (javafx.scene.layout.BorderPane)loader.load();

            javafx.scene.Scene scene = new javafx.scene.Scene(errorRootLayout);
            primaryErrorStage.setScene(scene);
            primaryErrorStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showErrorMensage() {
        initErrorRootLayout();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GuiApp.class.getResource("/ErrorLayout.fxml"));

            javafx.scene.layout.AnchorPane errorScene = (javafx.scene.layout.AnchorPane)loader.load();

            errorRootLayout.setCenter(errorScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
