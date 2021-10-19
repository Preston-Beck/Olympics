package Utilities;
import javafx.scene.chart.XYChart;
import Models.Country;
import java.sql.*;
import java.util.ArrayList;

public class DBUtilities {
    private static String username = "student";
    private static String password = "student";
    private static String connectURL = "jdbc:mysql://localhost:3306/olympicmedals";

    public static XYChart.Series<String, Integer> getGoldMedalsByCountry() {
        XYChart.Series<String, Integer> goldMedalData = new XYChart.Series<>();

        String sql = "SELECT country, goldMedals FROM olympics " +
                "GROUP BY country ORDER BY country ASC;";
        try (
                Connection connection = DriverManager.getConnection(connectURL, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            //Loop through the result set and fill the XYChart with data
            while (resultSet.next()) {
                goldMedalData.getData().add(new XYChart.Data<>(resultSet.getString("country"),
                        resultSet.getInt(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return goldMedalData;
    }

    public static XYChart.Series<String, Integer> getSilverMedalsByCountry()
    {
        XYChart.Series<String, Integer> silverMedalData = new XYChart.Series<>();

        String sql ="SELECT country, silverMedals FROM olympics " +
                "GROUP BY country ORDER BY country ASC;";
        try(
                Connection connection = DriverManager.getConnection(connectURL, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            //Loop through the result set and fill the XYChart with data
            while (resultSet.next())
            {
                silverMedalData.getData().add(new XYChart.Data<>(resultSet.getString("country"),
                        resultSet.getInt("silverMedals")));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return silverMedalData;
    }

    public static XYChart.Series<String, Integer> getBronzeMedalsByCountry()
    {
        XYChart.Series<String, Integer> bronzeMedalData = new XYChart.Series<>();

        String sql ="SELECT country, bronzeMedals FROM olympics " +
                "GROUP BY country ORDER BY country ASC;";
        try(
                Connection connection = DriverManager.getConnection(connectURL, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            //Loop through the result set and fill the XYChart with data
            while (resultSet.next())
            {
                bronzeMedalData.getData().add(new XYChart.Data<>(resultSet.getString("country"),
                        resultSet.getInt("bronzeMedals")));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return bronzeMedalData;
    }

    public static XYChart.Series<String, Integer> getTotalMedalsByCountry()
    {
        XYChart.Series<String, Integer> totalMedalData = new XYChart.Series<>();

        String sql ="SELECT country, totalMedals FROM olympics " +
                "GROUP BY country ORDER BY country ASC;";
        try(
                Connection connection = DriverManager.getConnection(connectURL, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            //Loop through the result set and fill the XYChart with data
            while (resultSet.next())
            {
                totalMedalData.getData().add(new XYChart.Data<>(resultSet.getString("country"),
                        resultSet.getInt("totalMedals")));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return totalMedalData;
    }

    public static ArrayList<Country> getCountry()
    {
        ArrayList<Country> countries = new ArrayList<>();

        String sql ="SELECT countryID, country, goldMedals, silverMedals, bronzeMedals, totalMedals, population " +
                "FROM olympics GROUP BY country ORDER BY totalMedals DESC;";

        try(
                Connection connection = DriverManager.getConnection(connectURL, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            while (resultSet.next())
            {
                int countryID = resultSet.getInt("countryID");
                String country = resultSet.getString("country");
                int goldMedals = resultSet.getInt("goldMedals");
                int silverMedals = resultSet.getInt("silverMedals");
                int bronzeMedals = resultSet.getInt("bronzeMedals");
                int totalMedals = resultSet.getInt("totalMedals");
                int population = resultSet.getInt("population");

                Country newCountry = new Country(country,goldMedals,silverMedals,bronzeMedals,totalMedals,population);
                newCountry.setCountryID(countryID);
                countries.add(newCountry);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return countries;
    }
}