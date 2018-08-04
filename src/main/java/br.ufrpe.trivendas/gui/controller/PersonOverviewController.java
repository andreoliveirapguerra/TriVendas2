package br.ufrpe.trivendas.gui.controller;

import br.ufrpe.trivendas.beans.Crawler;
import br.ufrpe.trivendas.gui.model.GuiApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PersonOverviewController implements Initializable {
    //toggle button config
    @FXML private ToggleGroup favLangToggleGroup = new ToggleGroup();
    @FXML private ToggleButton WalmartToggleButton;
    private boolean walmartSelection = false;
    @FXML private ToggleButton AliexpressToggleButton;
    @FXML private Button SearchProduct;
    private boolean aliexSelction = false;
    @FXML private Label toggleButtonLabel = new Label();
    private BorderPane rootLayoutResult = new BorderPane();

    //error treat
    ErrorLayoutController error = new ErrorLayoutController();

    //label settings
    @FXML private Label SitesLabel, ProductNameLabel, resultsLabel;
    @FXML private ProgressIndicator indicator;
    //text Area List View
    @FXML private TextArea golfTextArea = new TextArea();
    @FXML private TextField productNameField;
    @FXML private Label textAreaLabel;
    @FXML private BorderPane rootLayout = new BorderPane();
    @FXML SplitPane frontScene = new SplitPane();

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML private Stage primaryStage;

    /**
     * Craler Related stuff
     * */
    private Crawler crawlerAli = new Crawler();
    private Crawler crawlerWalmart = new Crawler();;
    private List resultNameWalmart = new ArrayList();
    private List resultsNameAli = new ArrayList();
    private List resultsPriceWalmart = new ArrayList();
    private List resultPriceAli = new ArrayList();

//    private ResultsLayoutController resultsScene =  new ResultsLayoutController(searchResult);

    private ErrorLayoutController erro = new ErrorLayoutController();

    @FXML
    public void searchButtonPushed(ActionEvent event) throws IOException
    {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ResultsLayout.fxml"));
            frontScene = loader.load(); // ta dando LoadExecption nessa linha

            //define tela login dentro do root
            rootLayoutResult.setCenter(frontScene);

            //test what button is selected
            search();

            showResultsLayout();

        } catch (Exception e){
            e.printStackTrace();
            erro.showErrorMensage();
        }
    }


    public void search(){

        if (this.AliexpressToggleButton.isSelected() ){
            indicator.setVisible(true);
            indicator.setProgress(0);
            String Resultado = productNameField.getText();

            resultsNameAli = crawlerAli.Crawl("Aliexpress", Resultado);

            indicator.setProgress(25);
            crawlerAli.run();
            indicator.setProgress(50);
        }
        if (this.WalmartToggleButton.isSelected() ){
            if (this.AliexpressToggleButton.isSelected()){
                indicator.setProgress(50);
            } else {
                indicator.setVisible(true);
                indicator.setProgress(0);
            }
            String Resultado = productNameField.getText();
            resultNameWalmart = crawlerWalmart.Crawl("Walmart", Resultado);

            indicator.setProgress(indicator.getProgress() + 25);

            crawlerWalmart.run();
            indicator.setProgress(indicator.getProgress() + 25);
        }
    }




    public void showResultsLayout(){
        try {
            //carrega tela de pesquisa
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GuiApp.class.getResource("/PersonOverview.fxml"));
            SplitPane frontScene = loader.load();

//            Scene cena = (Scene) frontScene;

            ResultsLayoutController controller = loader.getController();
            controller.generateList(resultNameWalmart, resultsPriceWalmart);
            controller.generateList(resultsNameAli, resultPriceAli);

            //define tela login dentro do root

            rootLayout.setCenter(frontScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            erro.showErrorMensage();
        }

    }


    public void walmartButtonPushed(){
        walmartSelection = !walmartSelection;
    }

    public void setWalmartSelection(boolean walmartSelection) {
        this.walmartSelection = walmartSelection;
    }

    public void aliButtonPressed (){
        aliexSelction = !aliexSelction;
    }

    public void setAliexSelction(boolean aliexSelction) {
        this.aliexSelction = aliexSelction;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        SitesLabel.setText("Online Retainer: ");
//        ProductNameLabel.setText("Products: ");
//        resultsLabel.setText("Here the search results");
        setWalmartSelection(false);
        setAliexSelction(false);

        this.WalmartToggleButton.setToggleGroup(favLangToggleGroup);
        this.AliexpressToggleButton.setToggleGroup(favLangToggleGroup);
    }
}
