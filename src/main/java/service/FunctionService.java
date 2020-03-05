package service;

import javafx.scene.chart.XYChart;

public class FunctionService {


    public XYChart.Series createLinearChart(double a, double b) {
        // assume that our chart will be draw from range -10 to 10

        XYChart.Series series = new XYChart.Series();

        for (int i = -10; i < 10; i++) {
            series.getData().add(new XYChart.Data<>(String.valueOf(i), i * a + b));

        }

        return series;
    }


    public XYChart.Series createQuadraticChart(double a, double b, double c) {

        XYChart.Series series = new XYChart.Series();

        for (int i = -10; i < 10; i++) {

            series.getData().add(new XYChart.Data<>(String.valueOf(i), a * i * i + b * i + c));
        }
        return series;
    }

    public XYChart.Series createLogarihmicSerie(double a, double b, double c) {

        XYChart.Series series = new XYChart.Series();

        for (double i = c + 0.01; i < 10; i += 0.5) {

            series.getData().add(new XYChart.Data<>(String.valueOf(i), (Math.log(i - c) / Math.log(a)) + b));
        }
        return series;
    }

    public XYChart.Series createExpontentialSeries(double a, double b, double c) {

        XYChart.Series series = new XYChart.Series<>();

        for (int i = -10; i <10 ; i++) {

            series.getData().add(new XYChart.Data<>(String.valueOf(i),Math.pow(a,i-b)+c));

        }

        return series;


    }

}
