// Inventory Items Class - Each item from database is an object of this class
package inventorycontrolsystem.inventorycontrolsystem;

public class InventoryItems {
    private int productID;
    private String skuNumber;
    private String productName;
    private int brandID;
    private String category;
    private int aisleLocation;
    private int quantity;
    private int reorderLevel;
    private double price;
    private double cost;
    private int sales;

    public InventoryItems(int productID, String skuNumber, String productName, int brandID, String category, int aisleLocation, int quantity, int reorderLevel, double price, double cost, int sales) {
        this.productID = productID;
        this.skuNumber = skuNumber;
        this.productName = productName;
        this.brandID = brandID;
        this.category = category;
        this.aisleLocation = aisleLocation;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
        this.price = price;
        this.cost = cost;
        this.sales = sales;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getSkuNumber() {
        return skuNumber;
    }

    public void setSkuNumber(String skuNumber) {
        this.skuNumber = skuNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAisleLocation() {
        return aisleLocation;
    }

    public void setAisleLocation(int aisleLocation) {
        this.aisleLocation = aisleLocation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
