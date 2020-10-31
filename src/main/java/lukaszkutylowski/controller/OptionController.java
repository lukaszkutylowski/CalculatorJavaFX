package lukaszkutylowski.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OptionController {

    @FXML
    private TextField precisionTextField;

    private HomeController homeController;
    private CalculateController calculateController;

    private Integer precision = 5;

    @FXML
    public void backMenu() {
        homeController.loadMenuScreen();
    }

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

    @FXML
    public void getPrecisionValue() {
        String filePath = "C:\\Users\\Łukasz\\IdeaProjects\\SimpleJavaFxCalculator\\src\\main\\resources\\precision\\precision.txt";
        File file = new File(filePath);
        String precisionString = precisionTextField.getText();
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(precisionString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
