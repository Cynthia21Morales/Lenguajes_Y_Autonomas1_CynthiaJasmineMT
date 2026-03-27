package com.jasminesystems.analizadorsintactico.sintactico;

public class ErrorSintactico extends RuntimeException {
    public ErrorSintactico(String mensaje) {
        super(mensaje);
    }
}