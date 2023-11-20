module inventorycontrolsystem.inventorycontrolsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens inventorycontrolsystem.inventorycontrolsystem to javafx.fxml;
    exports inventorycontrolsystem.inventorycontrolsystem;
}