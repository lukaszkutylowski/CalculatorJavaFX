package lukaszkutylowski.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {

    private HomeController homeController;

    @FXML
    public void openApplication() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Calculate.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CalculateController calculateController = loader.getController();
        calculateController.setHomeController(homeController);
        homeController.setScreen(pane);
    }

    @FXML
    public void options() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Option.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OptionController optionController = loader.getController();
        optionController.setHomeController(homeController);
        homeController.setScreen(pane);
    }

    @FXML
    public void exit() {
        Platform.exit();
    }

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }
}
