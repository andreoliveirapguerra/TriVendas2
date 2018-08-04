package br.ufrpe.trivendas.gui.model;

import java.io.IOException;

import br.ufrpe.trivendas.gui.controller.ErrorLayoutController;
import br.ufrpe.trivendas.gui.controller.PersonOverviewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiApp extends javafx.application.Application
{

    @FXML
    private Stage primaryStage;
    @FXML
    private static BorderPane rootLayout;
    ErrorLayoutController erro = new ErrorLayoutController();


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(javafx.stage.Stage stage)
            throws Exception
    {
        primaryStage = stage;
        primaryStage.setTitle("TriVendas");

        initRootLayout(2);

        showPersonOverview();
    }

    public void initRootLayout(int x)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/RootLayout.fxml"));
            rootLayout = (javafx.scene.layout.BorderPane)loader.load();

            javafx.scene.Scene scene = new javafx.scene.Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            erro.showErrorMensage();;
        }
    }



    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GuiApp.class.getResource("/PersonOverview.fxml"));

            VBox personOverview = loader.load();
            PersonOverviewController controller = loader.getController();
            controller.setPrimaryStage(primaryStage);

            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            System.out.println("erro");
            e.printStackTrace();
            erro.showErrorMensage();
        }
    }
}