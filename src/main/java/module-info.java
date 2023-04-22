module com.uniquindio.agenda.agenda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    exports com.uniquindio.agenda.controllers;
    opens com.uniquindio.agenda.controllers to javafx.fxml;
    exports com.uniquindio.agenda.application to javafx.graphics;

}