package lukaszkutylowski.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class CalculateController {

    @FXML
    private Label result;
    @FXML
    private Label showSign;
    private HomeController homeController;

    private String resultValue = "";
    private BigDecimal number1;
    private BigDecimal number2;
    private BigDecimal resultNumber;
    private Integer precision;
    private char sign;
    private boolean isFirstNumber = true;

    @FXML
    public void backMenu() {
        homeController.loadMenuScreen();
    }

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

    /*
    *   Click Numbers methods declarations:
    * */

    @FXML
    public void click1() {
        resultValue += "1";
        result.setText(resultValue);
    }

    @FXML
    public void click2() {
        resultValue += "2";
        result.setText(resultValue);
    }

    @FXML
    public void click3() {
        resultValue += "3";
        result.setText(resultValue);
    }

    @FXML
    public void click4() {
        resultValue += "4";
        result.setText(resultValue);
    }

    @FXML
    public void click5() {
        resultValue += "5";
        result.setText(resultValue);
    }

    @FXML
    public void click6() {
        resultValue += "6";
        result.setText(resultValue);
    }

    @FXML
    public void click7() {
        resultValue += "7";
        result.setText(resultValue);
    }

    @FXML
    public void click8() {
        resultValue += "8";
        result.setText(resultValue);
    }

    @FXML
    public void click9() {
        resultValue += "9";
        result.setText(resultValue);
    }

    @FXML
    public void click0() {
        resultValue += "0";
        result.setText(resultValue);
    }

    @FXML
    public void clickDot() {
        resultValue += ".";
        result.setText(resultValue);
    }

    /*
    *   Set Sign operations:
    * */

    @FXML
    public void plus() {
        if (isFirstNumber) {
            sign = '+';
            additionalOperationsIfFirstNumber();
        } else {
            additionalOperationsIfSecondNumber();
        }
        showSign.setText("+");
    }

    @FXML
    public void minus() {
        if (isFirstNumber) {
            sign = '-';
            additionalOperationsIfFirstNumber();
        } else {
            additionalOperationsIfSecondNumber();
        }
        String s = "+";
        showSign.setText(s);
    }

    @FXML
    public void multiply() {
        if (isFirstNumber) {
            sign = '*';
            additionalOperationsIfFirstNumber();
        } else {
            additionalOperationsIfSecondNumber();
        }
        showSign.setText("*");
    }

    @FXML
    public void divide() {
        if (isFirstNumber) {
            sign = '/';
            additionalOperationsIfFirstNumber();
        } else {
            additionalOperationsIfSecondNumber();
        }
        showSign.setText("/");
    }

    /*
    *   Set Sign private methods:
    * */

    private void additionalOperationsIfFirstNumber() {
        number1 = new BigDecimal(resultValue);
        resultValue = "";
        isFirstNumber = false;
    }

    private void additionalOperationsIfSecondNumber() {
        number2 = new BigDecimal(resultValue);
        resultValue = "";
        isFirstNumber = true;
        clickEquals();
    }

    /*
    *   Click Equals method:
    * */

    @FXML
    public void clickEquals() {
        setPrecision();
        number2 = new BigDecimal(resultValue);

        switch (sign) {
            case '+':
                resultNumber = number1.add(number2, MathContext.DECIMAL32).setScale(precision, BigDecimal.ROUND_HALF_UP);
                showCalculate("+", resultNumber);
                break;
            case '-':
                resultNumber = number1.subtract(number2, MathContext.DECIMAL32).setScale(precision, BigDecimal.ROUND_HALF_UP);
                showCalculate("-", resultNumber);
                break;
            case '*':
                resultNumber = number1.multiply(number2, MathContext.DECIMAL32).setScale(precision, BigDecimal.ROUND_HALF_UP);
                showCalculate("*", resultNumber);
                break;
            case '/':
                resultNumber = number1.divide(number2, MathContext.DECIMAL32).setScale(precision, BigDecimal.ROUND_HALF_UP);
                showCalculate("-", resultNumber);
                break;
        }
    }

    /*
    *   Click Equals private method:
    * */

    private void showCalculate(String setSign, BigDecimal resultNumber) {
        resultValue = resultNumber.toString();
        result.setText(resultValue);
    }

    /*
    *   Delete method:
    * */

    @FXML
    public void delete() {
        number1 = null;
        number2 = null;
        isFirstNumber = true;
        resultValue = "";
        showSign.setText(resultValue);
        result.setText(resultValue);
    }

    /*
    *   Set precision method
    * */

    public void setPrecision() {
        String filePath = "C:\\Users\\Łukasz\\IdeaProjects\\SimpleJavaFxCalculator\\src\\main\\resources\\precision\\precision.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String precisionString = scanner.nextLine().trim();
        precision = Integer.parseInt(precisionString);
    }
}
