package inventorycontrolsystem.inventorycontrolsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ICSItemViewController implements Initializable {
    @FXML
    private AnchorPane anchorItemLibrary;
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
        private TableColumn<InventoryItems, Integer> Quantity;
        @FXML
        private TableColumn<InventoryItems, Integer> ReorderLevel;
        @FXML
        private TableColumn<InventoryItems, String> SKU;
        @FXML
        private TableColumn<InventoryItems, Integer> Sales;
    @FXML
    private TextField tfAisleLocation;
    @FXML
    private TextField tfBrandID;
    @FXML
    private TextField tfCategory;
    @FXML
    private TextField tfCost;
    @FXML
    private TextField tfPrice;
    @FXML
    private TextField tfProductID;
    @FXML
    private TextField tfProductName;
    @FXML
    private TextField tfQuantity;
    @FXML
    private TextField tfReorderLevel;
    @FXML
    private TextField tfSKU;
    @FXML
    private TextField tfSales;
    @FXML
    private Button bTItemLibrary;
    @FXML
    private Button bTPricingUpdates;
    @FXML
    private Button bTPushOverstock;
    @FXML
    private TextField tFSearchBar;
    @FXML
    private Button bTAdd;
    @FXML
    private Button bTUpdate;
    @FXML
    private Button bTDelete;
    @FXML
    private Button bTClear;

    @FXML
    void bTItemLibraryPush(ActionEvent event) {

    }
    @FXML
    void bTPricingUpdatesPush(ActionEvent event) {

    }
    @FXML
    void bTPushOverstockPush(ActionEvent event) {
        pushOverstock();
    }
    @FXML
    void bTClearPush(ActionEvent event) {
        clearTextFields();
    }

    @FXML
    void bTAddPush(ActionEvent event) {
        addToDatabase();
    }
    @FXML
    void bTUpdatePush(ActionEvent event) {
        updateDatabaseEntry();
    }
    @FXML
    void btDeletePush(ActionEvent event) {
        deleteDatabaseEntry();
    }

    private void clearTextFields() { // Clear text fields on button push
        tfProductID.setText("");
        tfSKU.setText("");
        tfProductName.setText("");
        tfBrandID.setText("");
        tfCategory.setText("");
        tfAisleLocation.setText("");
        tfQuantity.setText("");
        tfReorderLevel.setText("");
        tfPrice.setText("");
        tfCost.setText("");
        tfSales.setText("");
    }

    public void addToDatabase() { // Add inputted object to the database after add button push
        Connection connection = SQLConnector.connectToDB();
        String sqlStatement = "INSERT into inventorysystemdatabase (ProductID, SKU, ProductName, BrandID, Category, " +
                "AisleLocation, Quantity, ReorderLevel, Price, Cost, Sales) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try{ // Add each value from the textfields input and add it to the sql statement using set string
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, tfProductID.getText());
            preparedStatement.setString(2, tfSKU.getText());
            preparedStatement.setString(3, tfProductName.getText());
            preparedStatement.setString(4, tfBrandID.getText());
            preparedStatement.setString(5, tfCategory.getText());
            preparedStatement.setString(6, tfAisleLocation.getText());
            preparedStatement.setString(7, tfQuantity.getText());
            preparedStatement.setString(8, tfReorderLevel.getText());
            preparedStatement.setString(9, tfPrice.getText());
            preparedStatement.setString(10, tfCost.getText());
            preparedStatement.setString(11, tfSales.getText());
            preparedStatement.execute();
            updateTableView();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDatabaseEntry() { // Edit selected database entry based on Product ID
        try {
            Connection connection = SQLConnector.connectToDB();

            String value1 = tfProductID.getText(); // Set all text fields to string values to add to sql statement
            String value2 = tfSKU.getText();
            String value3 = tfProductName.getText();
            String value4 = tfBrandID.getText();
            String value5 = tfCategory.getText();
            String value6 = tfAisleLocation.getText();
            String value7 = tfQuantity.getText();
            String value8 = tfReorderLevel.getText();
            String value9 = tfPrice.getText();
            String value10 = tfCost.getText();
            String value11 = tfSales.getText();

            // Set sql statement to update database with text field strings
            String sqlStatement = "UPDATE inventorysystemdatabase SET ProductID = '"+value1+"',SKU='"+value2+"',ProductName='"+
                    value3+"',BrandID='"+value4+"',Category='"+value5+"',AisleLocation='"+value6+"',Quantity='"+
                    value7+"',ReorderLevel='"+value8+"',Price='"+value9+"',Cost='"+value10+"',Sales='"+value11+"' WHERE ProductID='"+value1+"' ";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement); // Run statement
            preparedStatement.execute();
            updateTableView();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateTableView() { // Initialize table view with values from database
        ObservableList<InventoryItems> observableList;
        ProductID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        SKU.setCellValueFactory(new PropertyValueFactory<>("skuNumber"));
        ProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        BrandID.setCellValueFactory(new PropertyValueFactory<>("brandID"));
        Category.setCellValueFactory(new PropertyValueFactory<>("category"));
        AisleLocation.setCellValueFactory(new PropertyValueFactory<>("aisleLocation"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("aisleLocation"));
        ReorderLevel.setCellValueFactory(new PropertyValueFactory<>("reorderLevel"));
        Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        Cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        Sales.setCellValueFactory(new PropertyValueFactory<>("sales"));

        observableList = SQLConnector.getDataInventoryItems(); // Get values from database using SQLConnector Class
        InventoryTable.setItems(observableList); // Set table values using values pulled
        tFSearchBar.textProperty().addListener((observable, oldValue, newValue) -> InventoryTable.setItems(filterList(observableList, newValue))); // Update table according to search
    }

    @FXML
    void setSelectedTableValues(MouseEvent event) { // When user selects table value, fill text fields automatically
        int index = InventoryTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) { // Ignore if none are selected are
            return;
        }
        tfProductID.setText(ProductID.getCellData(index).toString()); // Update all
        tfSKU.setText(SKU.getCellData(index));
        tfProductName.setText(ProductName.getCellData(index));
        tfBrandID.setText(BrandID.getCellData(index).toString());
        tfCategory.setText(Category.getCellData(index));
        tfAisleLocation.setText(AisleLocation.getCellData(index).toString());
        tfQuantity.setText(Quantity.getCellData(index).toString());
        tfReorderLevel.setText(ReorderLevel.getCellData(index).toString());
        tfPrice.setText(Price.getCellData(index).toString());
        tfCost.setText(Cost.getCellData(index).toString());
        tfSales.setText(Sales.getCellData(index).toString());
    }

    public void deleteDatabaseEntry() { // Delete entry based on Product ID
        Connection connection = SQLConnector.connectToDB();
        String sqlStatement = "DELETE FROM inventorysystemdatabase WHERE ProductID = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, tfProductID.getText());
            preparedStatement.execute();
            updateTableView();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    // Functionality for search bar, compare each value of the class to the search text.
    // This is called everytime the user types in the search box
    private boolean searchTextForMatch(InventoryItems inventoryItems, String searchText) {
        searchText = searchText.toLowerCase(); // Set text to lowercase automatically
        return (Integer.valueOf(inventoryItems.getProductID()).toString().equals(searchText) ||
                inventoryItems.getSkuNumber().toLowerCase().contains(searchText) ||
                inventoryItems.getProductName().toLowerCase().contains(searchText) ||
                Integer.valueOf(inventoryItems.getBrandID()).toString().equals(searchText) ||
                inventoryItems.getCategory().toLowerCase().contains(searchText) ||
                Integer.valueOf(inventoryItems.getAisleLocation()).toString().equals(searchText) ||
                Integer.valueOf(inventoryItems.getQuantity()).toString().equals(searchText) ||
                Double.valueOf(inventoryItems.getPrice()).toString().equals(searchText) ||
                Double.valueOf(inventoryItems.getCost()).toString().equals(searchText) ||
                Integer.valueOf(inventoryItems.getSales()).toString().equals(searchText)
        );
    }

    // Filter list to filter through table and search each column for text typed into search bar
    private ObservableList<InventoryItems> filterList(List<InventoryItems> list, String searchText) {
        List<InventoryItems> filteredList = new ArrayList<>(); // Filter list
        for (InventoryItems inventoryItems : list) { // Loop through all items in class
            if (searchTextForMatch(inventoryItems, searchText)) { // Search each column for entered text
                filteredList.add(inventoryItems); // Add matches to new tableview filter list
            }
        }
        return FXCollections.observableList(filteredList);// Return new filtered items table to display
    }



    private void pushOverstock() {
        // If sales value changes for a item, add it to a new observable list to show items to push
        ObservableList<InventoryItems> observableList;
        observableList = SQLConnector.getDataInventoryItems(); // Get values from database using SQLConnector Class
        Sales.textProperty().addListener((observable, oldValue, newValue) -> InventoryTable.setItems(filterList(observableList, newValue))); // Update table according to search
    }

    private void pricingUpdates() {
        // If an items price is changed, add it to a new observable list to show items to change price labels on
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { // Initialize table view with values from database
        updateTableView();
    }
}