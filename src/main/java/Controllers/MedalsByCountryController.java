package Controllers;

import Utilities.DBUtilities;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class MedalsByCountryController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis countryAxis;

    @FXML
    private NumberAxis medalsAxis;

    @FXML
    private RadioButton goldMedalRB;

    @FXML
    private ToggleGroup graphControls;

    @FXML
    private RadioButton silverMedalRB;

    @FXML
    private RadioButton bronzeMedalRB;

    @FXML
    private RadioButton totalMedalsRB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Get chart data by calling the getGoldMedalsByCountry function
        barChart.getData().addAll(DBUtilities.getGoldMedalsByCountry());
        //Add title and labels for chart
        barChart.setTitle("Olympic Gold Medals");
        countryAxis.setLabel("Countries");
        medalsAxis.setLabel("Medals");
    }

    public void changed(ObservableValue<? extends Toggle> observed,
                        Toggle oldValue, Toggle newValue)
        {

            RadioButton radioButton = (RadioButton)graphControls.getSelectedToggle();

            if (radioButton == goldMedalRB) {
                barChart.getData().addAll(DBUtilities.getGoldMedalsByCountry());
                //Change title for chart
                barChart.setTitle("Olympic Gold Medals");
            }
            else if (radioButton == silverMedalRB) {
                barChart.getData().addAll(DBUtilities.getSilverMedalsByCountry());
                //Change title for chart
                barChart.setTitle("Olympic Silver Medals");
            }
            else if (radioButton == bronzeMedalRB) {
                barChart.getData().addAll(DBUtilities.getBronzeMedalsByCountry());
                //Change title for chart
                barChart.setTitle("Olympic Bronze Medals");
            }
            else if (radioButton == totalMedalsRB) {
                barChart.getData().addAll(DBUtilities.getTotalMedalsByCountry());
                //Change title for chart
                barChart.setTitle("Olympic Total Medals");
            }
        }
}
