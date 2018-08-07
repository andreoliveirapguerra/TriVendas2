package br.ufrpe.trivendas.gui.controller;

import br.ufrpe.trivendas.beans.Resultado;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ResultsLayoutController implements Initializable {
  @FXML
  private TableView searchResult ;
  @FXML
  private AnchorPane resultLayout = new AnchorPane();
  @FXML private TableColumn nameColumn;
  @FXML private TableColumn priceColumn;
  public ResultsLayoutController(TableView searchResult) {
    this.searchResult = searchResult;
  }
  private List<Resultado> listResult = new ArrayList<>();
  @FXML private ObservableList<Resultado> lista = FXCollections.observableList(listResult);


  public void generateList(List resultName, List resultPrice)
  {
    for (int i = 0; i < resultName.size(); i++) {
      double tempPrice = (double) resultPrice.get(i);
      String tempName = (String) resultName.get(i);
      listResult.add(new Resultado(tempName, tempPrice));
    }

  }

  @Override
  public void initialize(java.net.URL location, ResourceBundle resources)
  {
    for (int i = 0; i < listResult.size(); i++) {
      nameColumn.setCellValueFactory(new PropertyValueFactory<Resultado, String>("name"));
      priceColumn.setCellValueFactory(new PropertyValueFactory<Resultado, Double>("preco"));
    }
    searchResult.setItems(lista);
  }
}
