package com.jasminesystems.analisislexico.controller;

import com.jasminesystems.analisislexico.AnalizadorLexico;
import com.jasminesystems.analisislexico.Token;
import com.jasminesystems.analisislexico.ErrorLexico;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainController {

    @FXML
    private TextArea taCodigo;

    @FXML
    private TextArea taTokens;

    @FXML
    private TextArea taErrores;

    @FXML
    private Button btnAnalizar;

    @FXML
    private Button btnLimpiar;

    private AnalizadorLexico analizador = new AnalizadorLexico();

    @FXML
    private void initialize() {
        btnAnalizar.setOnAction(e -> analizarCodigo());
        btnLimpiar.setOnAction(e -> limpiar());
    }

    private void analizarCodigo() {
        String codigo = taCodigo.getText();
        analizador.analizar(codigo);

        // Mostrar tokens
        taTokens.clear();
        for (Token t : analizador.getTokens()) {
            taTokens.appendText(t + "\n");
        }

        // Mostrar errores
        taErrores.clear();
        for (ErrorLexico er : analizador.getErrores()) {
            taErrores.appendText(er + "\n");
        }
    }

    private void limpiar() {
        taCodigo.clear();
        taTokens.clear();
        taErrores.clear();
    }
}