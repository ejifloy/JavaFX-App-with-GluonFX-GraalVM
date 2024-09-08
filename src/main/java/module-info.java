module hellofxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires mysql.connector.j;

    opens hellofx to javafx.fxml;

    exports hellofx;
}