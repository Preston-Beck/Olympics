package Controllers;

import Utilities.DBUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.RadioButton;
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
}
