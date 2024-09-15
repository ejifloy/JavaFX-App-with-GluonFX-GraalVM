module hellofxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.mariadb.jdbc;

    opens hellofx to javafx.fxml;

    exports hellofx;
}