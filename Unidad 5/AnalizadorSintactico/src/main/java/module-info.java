module com.jasminesystems.analizadorsintactico {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.jasminesystems.analizadorsintactico to javafx.fxml;
    exports com.jasminesystems.analizadorsintactico;
    exports com.jasminesystems.analizadorsintactico.controller;
    opens com.jasminesystems.analizadorsintactico.controller to javafx.fxml;
}