package inventorycontrolsystem.inventorycontrolsystem;

import inventorycontrolsystem.inventorycontrolsystem.InventoryItems;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class SQLConnector {
    public static Connection connectToDB() { // Create SQL database collection and return that connection
        try{
            Connection connection = DriverManager.getConnection(// Connect to database
                    "jdbc:mysql://localhost:3306/inventorycontrolsystem",
                    "root",
                    "tiger"
            );
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static ObservableList<InventoryItems> getDataInventoryItems() { // Get data from table into objects
        Connection connection = connectToDB();
        ObservableList<InventoryItems> observableList = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM inventorysystemdatabase");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { // Loop through each entry and make it a new object from the InventoryItems class
                observableList.add(new InventoryItems(
                        Integer.parseInt(resultSet.getString("ProductID")),
                        resultSet.getString("SKU"),
                        resultSet.getString("ProductName"),
                        Integer.parseInt(resultSet.getString("BrandID")),
                        resultSet.getString("Category"),
                        Integer.parseInt(resultSet.getString("AisleLocation")),
                        Integer.parseInt(resultSet.getString("Quantity")),
                        Integer.parseInt(resultSet.getString("ReorderLevel")),
                        Double.parseDouble(resultSet.getString("Price")),
                        Double.parseDouble(resultSet.getString("Cost")),
                        Integer.parseInt(resultSet.getString("Sales"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return observableList;
    }
}


    //void connectToDB() {
    //    try{
    //        Connection connection = DriverManager.getConnection(
    //                "jdbc:mysql://localhost:3306/inventorycontrolsystem",
    //                "root",
    //                "tiger"
    //        );
    //        Statement statement = connection.createStatement();
    //        ResultSet resultSet = statement.executeQuery("SELECT * FROM inventorysystemdatabase");
    //        while (resultSet.next()) {
    //            System.out.println(resultSet.getString("ProductName"));
    //        }
    //    }catch (SQLException e){
    //        e.printStackTrace();
    //    }
    //}