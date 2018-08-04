package br.ufrpe.trivendas.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class RootErrorLayoutController implements Initializable {
    @FXML private BorderPane errorRootLayout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorRootLayout.setVisible(true);
    }
}
