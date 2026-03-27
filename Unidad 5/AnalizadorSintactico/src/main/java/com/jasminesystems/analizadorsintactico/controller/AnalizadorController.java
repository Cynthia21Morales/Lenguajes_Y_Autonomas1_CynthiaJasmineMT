package com.jasminesystems.analizadorsintactico.controller;

import com.jasminesystems.analizadorsintactico.lexico.AnalizadorLexico;
import com.jasminesystems.analizadorsintactico.lexico.Token;
import com.jasminesystems.analizadorsintactico.sintactico.AnalizadorSintactico;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.List;

public class AnalizadorController {

    @FXML
    private TextArea entrada;

    @FXML
    private TextArea salida;

    @FXML
    private Button btnAnalizar;

    @FXML
    private void analizar() {
        try {
            AnalizadorLexico lexico = new AnalizadorLexico(entrada.getText());
            List<Token> tokens = lexico.analizar();

            AnalizadorSintactico sintactico = new AnalizadorSintactico(tokens);
            sintactico.analizar();

            StringBuilder sb = new StringBuilder();
            sb.append("TOKENS:\n\n");

            for (Token t : tokens) {
                sb.append(t).append("\n");
            }

            sb.append("\n✔ Sintaxis correcta");

            salida.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");
            salida.setText(sb.toString());

        } catch (Exception e) {
            salida.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");
            salida.setText("✖ " + e.getMessage());
        }
    }

    //  EFECTO HOVER BOTÓN
    @FXML
    private void hoverOn() {
        btnAnalizar.setStyle("-fx-background-color: #00a98f; -fx-text-fill: white; -fx-font-size: 16px; -fx-background-radius: 25;");
    }

    @FXML
    private void hoverOff() {
        btnAnalizar.setStyle("-fx-background-color: #00c9a7; -fx-text-fill: white; -fx-font-size: 16px; -fx-background-radius: 25;");
    }
}