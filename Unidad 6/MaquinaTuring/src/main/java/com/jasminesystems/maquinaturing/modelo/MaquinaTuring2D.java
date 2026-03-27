package com.jasminesystems.maquinaturing.modelo;

import java.util.ArrayList;
import java.util.List;

/*
 * Representa la máquina de Turing 2D completa
 */
public class MaquinaTuring2D {

    // Cinta en forma de matriz (2D)
    public char[][] cinta;

    // Posición del cabezal
    public int fila = 2;
    public int columna = 2;

    // Estado actual
    public String estadoActual = "q0";

    // Lista de transiciones
    public List<Transicion> transiciones = new ArrayList<>();

    public MaquinaTuring2D() {

        // Inicializamos una matriz de 5x5
        cinta = new char[5][5];

        // Llenamos la cinta con símbolo blanco '_'
        for (int i = 0; i < cinta.length; i++) {
            for (int j = 0; j < cinta[i].length; j++) {
                cinta[i][j] = '_';
            }
        }
    }

    // Método para agregar transiciones
    public void agregarTransicion(Transicion t) {
        transiciones.add(t);
    }
}