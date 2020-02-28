package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import service.LinearFunctionService;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button button1;
    @FXML
    TextArea valueA;
    @FXML
    TextArea valueB;
    @FXML
    Label label;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private CategoryAxis x;

    LinearFunctionService linearFunctionService = new LinearFunctionService();
    static int a=1;
    static int b=1;


    @FXML
    private NumberAxis y;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText("test lejbelka");
        valueA.insertText(0,"wprowadź parametr b");
        valueB.insertText(0,"wprowadź parametr b");

        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("1",20));
        series.getData().add(new XYChart.Data("2",24));
        series.getData().add(new XYChart.Data("3",19));
        series.getData().add(new XYChart.Data("4",22));
        lineChart.getData().add(linearFunctionService.createLinearChart(a,b));

    }



    public void add(){
label.setText(String.valueOf(Integer.valueOf(valueA.getText())+Integer.valueOf(valueB.getText())));
a=Integer.valueOf(valueA.getText());
b=Integer.valueOf(valueB.getText());
lineChart.getData().remove(0);
lineChart.getData().add(linearFunctionService.createLinearChart(a,b));

    }
}
