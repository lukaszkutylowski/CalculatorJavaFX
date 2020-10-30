package lukaszkutylowski.controller;

import javafx.fxml.FXML;

public class OptionController {

    private HomeController homeController;

    @FXML
    public void backMenu() {
        homeController.loadMenuScreen();
    }

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }
}
