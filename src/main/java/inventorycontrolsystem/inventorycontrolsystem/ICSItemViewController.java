package inventorycontrolsystem.inventorycontrolsystem;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ICSItemViewController implements Initializable {

    @FXML
    private TableView<InventoryItems> InventoryTable;
    @FXML
    private TableColumn<InventoryItems, Integer> AisleLocation;

    @FXML
    private TableColumn<InventoryItems, Integer> BrandID;

    @FXML
    private TableColumn<InventoryItems, String> Category;

    @FXML
    private TableColumn<InventoryItems, Double> Cost;

    @FXML
    private TableColumn<InventoryItems, Double> Price;

    @FXML
    private TableColumn<InventoryItems, Integer> ProductID;

    @FXML
    private TableColumn<InventoryItems, String> ProductName;

    @FXML
    private TableColumn<InventoryItems, Double> Quantity;

    @FXML
    private TableColumn<InventoryItems, Integer> ReorderLevel;

    @FXML
    private TableColumn<InventoryItems, String> SKU;

    @FXML
    private TableColumn<InventoryItems, Integer> Sales;

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
    private Button bTAdd;
    @FXML
    private Button bTUpdate;
    @FXML
    private Button bTDelete;

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

    @FXML
    void bTAddPush(ActionEvent event) {

    }

    @FXML
    void bTUpdatePush(ActionEvent event) {

    }

    @FXML
    void btDeletePush(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { // Initialize table view with values from database
        ObservableList<InventoryItems> observableList;
        ProductID.setCellValueFactory(new PropertyValueFactory<InventoryItems,Integer>("productID"));
        SKU.setCellValueFactory(new PropertyValueFactory<InventoryItems, String>("sKU"));
        ProductName.setCellValueFactory(new PropertyValueFactory<InventoryItems, String>("productName"));
        BrandID.setCellValueFactory(new PropertyValueFactory<InventoryItems,Integer>("brandID"));
        Category.setCellValueFactory(new PropertyValueFactory<InventoryItems, String>("category"));
        AisleLocation.setCellValueFactory(new PropertyValueFactory<InventoryItems,Integer>("aisleLocation"));
        Quantity.setCellValueFactory(new PropertyValueFactory<InventoryItems,Double>("aisleLocation"));
        ReorderLevel.setCellValueFactory(new PropertyValueFactory<InventoryItems,Integer>("reorderLevel"));
        Price.setCellValueFactory(new PropertyValueFactory<InventoryItems,Double>("price"));
        Cost.setCellValueFactory(new PropertyValueFactory<InventoryItems,Double>("cost"));
        Sales.setCellValueFactory(new PropertyValueFactory<InventoryItems,Integer>("sales"));

        observableList = SQLConnector.getDataInventoryItems(); // Get values from database using SQLConnector Class
        InventoryTable.setItems(observableList); // Set table values using values pulled
    }
}
