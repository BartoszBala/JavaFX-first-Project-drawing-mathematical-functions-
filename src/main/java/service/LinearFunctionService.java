package service;

import javafx.scene.chart.XYChart;

public class LinearFunctionService {


    public XYChart.Series createLinearChart(int a, int b) {
        // assume that our chart will be draw from range -10 to 10

        XYChart.Series series = new XYChart.Series();

        for (int i = -10; i < 10; i++) {
            series.getData().add(new XYChart.Data<>(String.valueOf(i),i*a+b));

        }

        return series;
    }

}
