package com.jasminesystems.analizadorsintactico.gramatica;

import java.util.List;

public class Produccion {

    private String izquierda;
    private List<String> derecha;

    public Produccion(String izquierda, List<String> derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public String getIzquierda() {
        return izquierda;
    }

    public List<String> getDerecha() {
        return derecha;
    }

    @Override
    public String toString() {
        return izquierda + " -> " + String.join(" ", derecha);
    }
}