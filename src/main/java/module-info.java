module medals.olympics {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens medals.olympics to javafx.fxml;
    exports medals.olympics;
    exports Controllers;
    opens Controllers to javafx.fxml;
}