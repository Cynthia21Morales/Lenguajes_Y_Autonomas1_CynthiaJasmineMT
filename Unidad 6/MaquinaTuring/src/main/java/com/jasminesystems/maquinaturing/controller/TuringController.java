package com.jasminesystems.maquinaturing.controller;

import com.jasminesystems.maquinaturing.modelo.*;
import com.jasminesystems.maquinaturing.logica.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TuringController {

    @FXML
    private TextArea salida;

    private MaquinaTuring2D maquina;
    private SimuladorTuring2D simulador;

    private boolean ejecutando = false;

    @FXML
    public void initialize() {

        maquina = new MaquinaTuring2D();

        //  TRANSICIONES (movimiento en 4 direcciones)
        maquina.agregarTransicion(new Transicion("q0", '_', 'X', "q1", "DER"));
        maquina.agregarTransicion(new Transicion("q1", '_', 'X', "q2", "ABAJO"));
        maquina.agregarTransicion(new Transicion("q2", '_', 'X', "q3", "IZQ"));
        maquina.agregarTransicion(new Transicion("q3", '_', 'X', "q0", "ARRIBA"));

        simulador = new SimuladorTuring2D(maquina);

        mostrar();
    }

    @FXML
    private void paso() {
        simulador.paso();
        mostrar();
    }

    @FXML
    private void ejecutar() {
        ejecutando = true;

        new Thread(() -> {
            try {
                while (ejecutando) {
                    Thread.sleep(500);

                    javafx.application.Platform.runLater(() -> {
                        simulador.paso();
                        mostrar();
                    });
                }
            } catch (InterruptedException ignored) {}
        }).start();
    }

    @FXML
    private void detener() {
        ejecutando = false;
    }

    private void mostrar() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < maquina.cinta.length; i++) {
            for (int j = 0; j < maquina.cinta[i].length; j++) {

                if (i == maquina.fila && j == maquina.columna) {
                    sb.append("[").append(maquina.cinta[i][j]).append("]");
                } else {
                    sb.append(" ").append(maquina.cinta[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        sb.append("\nEstado: ").append(maquina.estadoActual);

        salida.setText(sb.toString());
    }
}