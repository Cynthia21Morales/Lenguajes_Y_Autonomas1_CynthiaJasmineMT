package com.jasminesystems.maquinaturing.modelo;

/*
 * Representa un estado de la máquina de Turing
 */
public class Estado {

    // Nombre del estado (ej: q0, q1)
    public String nombre;

    // Indica si es estado final
    public boolean esFinal;

    public Estado(String nombre, boolean esFinal) {
        this.nombre = nombre;
        this.esFinal = esFinal;
    }
}