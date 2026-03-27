module com.jasminesystems.analisislexico {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jasminesystems.analisislexico.controller to javafx.fxml;
    exports com.jasminesystems.analisislexico;
}