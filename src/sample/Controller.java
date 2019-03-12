package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Controller {
    @FXML
    TextField textField;

    @FXML
    TextField totalField;

   private Double total;
   private ArrayList<Double> numbers = new ArrayList<>();
   private String lastFunction = "clear";
   private Boolean equalPressed = false;


    @FXML
    private void numberButtonClick(Event event) throws Exception{
        if(equalPressed){
            clearButtonClick();
            equalPressed = false;
        }
        Button button = (Button) event.getSource();
        String id = button.getId();
        System.out.println(id);
        if(textField.getText().isEmpty()) {
            textField.setText(id);
        }else if(id.equals(".")){
                String decimal = textField.getText() + ". ";
                textField.appendText(decimal);
        }else{
            textField.setText(textField.getText().trim().concat(id));
        }
    }

    @FXML
    private void clearButtonClick() throws Exception{
        textField.clear();
        numbers.clear();
        totalField.clear();
        lastFunction = "clear";
    }

    @FXML
    private void addButtonClick() throws Exception{
        if(!lastFunction.equals("addition")){
            equalsButtonClick();
            equalPressed = false;
        }

        if (!textField.getText().isEmpty()) {
            if (numbers.isEmpty()) {
                total = Double.parseDouble(textField.getText());
                numbers.add(total);
                totalField.setText(numbers.get(0).toString());
                textField.clear();
            } else {
                Double secondNumber = new Double(textField.getText());
                Double sum = secondNumber + numbers.get(0);
                numbers.set(0, sum);
                totalField.setText(sum.toString());
                textField.clear();
            }
        }
        lastFunction = "addition";
    }
    @FXML
    private void subtractionButtonClick() throws Exception{
        if(!lastFunction.equals("subtraction")){
            equalsButtonClick();
            equalPressed = false;
        }
        if (!textField.getText().isEmpty()) {
            if (numbers.isEmpty()) {
                total = Double.parseDouble(textField.getText());
                numbers.add(total);
                totalField.setText(numbers.get(0).toString());
                textField.clear();
            } else {
                Double secondNumber = new Double(textField.getText());
                Double sum = numbers.get(0) - secondNumber;
                numbers.set(0, sum);
                totalField.setText(sum.toString());
                textField.clear();
            }
        }
        lastFunction = "subtraction";
    }
    @FXML
    private void multiplyButtonClick() throws Exception{
        if(!lastFunction.equals("multiplication")){
            equalsButtonClick();
            equalPressed = false;
        }
        if (!textField.getText().isEmpty()) {
            if (numbers.isEmpty()) {
                total = Double.parseDouble(textField.getText());
                numbers.add(total);
                totalField.setText(numbers.get(0).toString());
                textField.clear();
            } else {
                Double secondNumber = new Double(textField.getText());
                Double sum = numbers.get(0) * secondNumber;
                numbers.set(0, sum);
                totalField.setText(sum.toString());
                textField.clear();
            }
        }
        lastFunction = "multiplication";
    }
    @FXML
    private void divisionButtonClick() throws Exception{
        if(!lastFunction.equals("division")){
            equalsButtonClick();
            equalPressed = false;
        }

        if (!textField.getText().isEmpty()) {
            if (numbers.isEmpty()) {
                total = Double.parseDouble(textField.getText());
                numbers.add(total);
                totalField.setText(numbers.get(0).toString());
                textField.clear();
            } else {
                Double secondNumber = new Double(textField.getText());
                if(secondNumber == 0){
                    textField.setText("Can't divide by zero");

                }else {
                    Double sum = numbers.get(0) / secondNumber;
                    numbers.set(0, sum);
                    totalField.setText(sum.toString());
                    textField.clear();
                }
            }
        }
        lastFunction = "division";
    }

    @FXML
    private void equalsButtonClick() throws Exception{
        equalPressed = true;
        switch (lastFunction){
            case "addition":
                addButtonClick();
                break;
            case "subtraction":
                subtractionButtonClick();
                break;
            case "multiplication":
                multiplyButtonClick();
                break;
            case "division":
                divisionButtonClick();
                break;
            case "clear":
                break;
        }

    }


















}




