package inventorycontrolsystem.inventorycontrolsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;

public class ICSItemViewController {
    void initializeDB() {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/inventorycontrolsystem",
                    "root",
                    "tiger"
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM inventorycontrolsystem.inventorysystemdatabase");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ProductName"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    @FXML
    private Button bTCategories;

    @FXML
    private Button bTItemLibrary;

    @FXML
    private Button bTPricingUpdates;

    @FXML
    private Button bTPushOverstock;

    @FXML
    private Button bTSettings;

    @FXML
    private Button btMerchandising;

    @FXML
    private TextField tFSearchBar;

    @FXML
    private TextField tFwindowTitle;

    public ICSItemViewController() throws SQLException {
    }

    @FXML
    void bTCategoriesPush(ActionEvent event) {

    }

    @FXML
    void bTItemLibraryPush(ActionEvent event) {

    }

    @FXML
    void bTPricingUpdatesPush(ActionEvent event) {

    }

    @FXML
    void bTPushOverstockPush(ActionEvent event) {

    }

    @FXML
    void bTSettingsPush(ActionEvent event) {

    }

    @FXML
    void btMerchandisingPush(ActionEvent event) {

    }


}