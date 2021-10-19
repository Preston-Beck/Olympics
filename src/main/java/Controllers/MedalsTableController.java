package Controllers;

import Models.Country;
import Utilities.DBUtilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import medals.olympics.MedalsApplication;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MedalsTableController implements Initializable {

    @FXML
    private TableView<Country> medalsTableView;

    @FXML
    private TableColumn<Country, Integer> countryIDTableColumn;

    @FXML
    private TableColumn<Country, String> countryTableColumn;

    @FXML
    private TableColumn<Country, Integer> goldMedalsTableColumn;

    @FXML
    private TableColumn<Country, Integer> silverMedalsTableColumn;

    @FXML
    private TableColumn<Country, Integer> bronzeMedalsTableColumn;

    @FXML
    private TableColumn<Country, Integer> totalMedalsTableColumn;

    @FXML
    private TableColumn<Country, Integer> populationTableColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countryIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("countryID"));
        countryTableColumn.setCellValueFactory(new PropertyValueFactory<>("countryName"));
        goldMedalsTableColumn.setCellValueFactory(new PropertyValueFactory<>("goldMedals"));
        silverMedalsTableColumn.setCellValueFactory(new PropertyValueFactory<>("silverMedals"));
        bronzeMedalsTableColumn.setCellValueFactory(new PropertyValueFactory<>("bronzeMedals"));
        totalMedalsTableColumn.setCellValueFactory(new PropertyValueFactory<>("totalMedals"));
        populationTableColumn.setCellValueFactory(new PropertyValueFactory<>("population"));

        medalsTableView.getItems().addAll(DBUtilities.getCountry());
    }

    @FXML
    public void changeScenes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MedalsApplication.class.getResource("medals-by-country.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Medals Won");
        stage.setScene(scene);
        stage.show();
    }
}
