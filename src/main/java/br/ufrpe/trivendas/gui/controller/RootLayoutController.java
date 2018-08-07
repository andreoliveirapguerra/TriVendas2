package br.ufrpe.trivendas.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class RootLayoutController implements javafx.fxml.Initializable
{
  @FXML
  private BorderPane rootLayout;
  
  public RootLayoutController() {}
  
  public void initialize(URL location, ResourceBundle resources)
  {
    rootLayout = rootLayout;
    System.out.println("kk eae man?");
  }
}
