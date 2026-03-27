module com.jasminesystems.maquinaturing {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.jasminesystems.maquinaturing to javafx.fxml;
    exports com.jasminesystems.maquinaturing;
    exports com.jasminesystems.maquinaturing.controller;
    opens com.jasminesystems.maquinaturing.controller to javafx.fxml;
}