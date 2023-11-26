package inventorycontrolsystem.inventorycontrolsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;


public class ICSItemViewApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        initializeDB();

        FXMLLoader fxmlLoader = new FXMLLoader(ICSItemViewApp.class.getResource("ICSItemView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Inventory Control System");
        stage.setScene(scene);
        stage.show();
    }
    void initializeDB() {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/inventorycontrolsystem",
                    "root",
                    "tiger"
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM inventorysystemdatabase");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ProductName"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}