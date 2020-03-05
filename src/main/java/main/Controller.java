package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import service.FunctionService;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    TextArea valueA;
    @FXML
    TextArea valueB;
    @FXML
    TextArea valueC;
    @FXML
    private LineChart<?, ?> lineChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    private CheckBox checkBox = new CheckBox("checkBox");
    @FXML
    private Label labelForInvalidNumber = new Label("");

    FunctionService linearFunctionService = new FunctionService();
    static double a = 1;
    static double b = 1;
    static double c = 1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valueA.insertText(0, "a");
        valueB.insertText(0, "b");
        x.setStartMargin(-1);
        y.setAutoRanging(true);
        y.setLowerBound(-20);
        y.setUpperBound(20);
        checkBox.setSelected(true);
        lineChart.getData().add(linearFunctionService.createLinearChart(a, b));

    }


    public void drawLinearFunction() {
        trySetCoefficient();
        lineChart.setAnimated(false);
        removeSeriesIfCheckBoxSelected();
        XYChart.Series series = linearFunctionService.createLinearChart(a, b);
        lineChart.getData().add(series);
        series.setName("y=" + a + "x+" + b);
        y.setAutoRanging(true);

    }


    public void drawQuadraticFunction() {
        trySetCoefficient();
        lineChart.setAnimated(false);
        removeSeriesIfCheckBoxSelected();
        XYChart.Series series = linearFunctionService.createQuadraticChart(a, b, c);
        lineChart.getData().add(series);
        series.setName("y=" + a + "x^2+" + b + "x" + c);
        y.setAutoRanging(true);

    }

    public void drawLogarithmicFunction() {
        trySetCoefficient();
        lineChart.setAnimated(false);
        removeSeriesIfCheckBoxSelected();
        XYChart.Series series = linearFunctionService.createLogarihmicSerie(a, b, c);
        lineChart.getData().add(series);
//        series.setName("y=log("+a+")(x-"+b+")+"+c);
        y.setAutoRanging(true);

    }

    public void drawExponentialFunction() {
        trySetCoefficient();
        lineChart.setAnimated(false);
        removeSeriesIfCheckBoxSelected();
        XYChart.Series series = linearFunctionService.createExpontentialSeries(a, b, c);
        lineChart.getData().add(series);
        series.setName("y=log(" + a + ")(x-" + b + ")+" + c);
        y.setAutoRanging(true);

    }

    private void trySetCoefficient() {
        try {
            labelForInvalidNumber.setText("");
            a = Double.valueOf(valueA.getText());
            b = Double.valueOf(valueB.getText());
            c = Double.valueOf(valueC.getText());
        } catch (NumberFormatException e) {

            labelForInvalidNumber.setText("put number in fields");

        }
    }

    private void removeSeriesIfCheckBoxSelected() {
        if (checkBox.isSelected()) {
            lineChart.getData().clear();
        }
    }


}
