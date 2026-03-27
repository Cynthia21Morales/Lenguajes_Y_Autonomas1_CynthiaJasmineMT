package com.jasminesystems.analisislexico;

public class ErrorLexico {
    private String caracter;
    private int posicion;

    public ErrorLexico(String caracter, int posicion) {
        this.caracter = caracter;
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Error: símbolo no reconocido '" + caracter + "' en posición " + posicion;
    }
}