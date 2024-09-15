package hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloFXML extends Application {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "pw123456";

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Label label = new Label("Click the button to connect to MySQLDB...");
        Button connectButton = new Button("Connect to MySQLDB");

        connectButton.setOnAction(event -> {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                label.setText("Connection successful!");
            } catch (ClassNotFoundException | SQLException e) {
                label.setText("Connection failed: " + e.getMessage());
                System.out.println("Error: "+e);
            }
        });

        root.getChildren().addAll(label, connectButton);

        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add(getClass().getResource("/hellofx/style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX MySQLDB Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}