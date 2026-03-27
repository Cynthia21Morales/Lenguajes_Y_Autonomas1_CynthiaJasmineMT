package com.jasminesystems.maquinaturing.modelo;

/*
 * Representa una transición de la máquina
 * (estadoActual, simboloLeido) → (simboloEscrito, siguienteEstado, movimiento)
 */
public class Transicion {

    public String estadoActual;      // Estado en el que está la máquina
    public char simboloLeido;        // Símbolo que se lee en la cinta
    public char simboloEscrito;      // Símbolo que se escribe
    public String siguienteEstado;   // Estado al que se pasa
    public String movimiento;        // Movimiento: ARRIBA, ABAJO, IZQ, DER

    public Transicion(String estadoActual, char simboloLeido,
                      char simboloEscrito, String siguienteEstado,
                      String movimiento) {

        this.estadoActual = estadoActual;
        this.simboloLeido = simboloLeido;
        this.simboloEscrito = simboloEscrito;
        this.siguienteEstado = siguienteEstado;
        this.movimiento = movimiento;
    }
}