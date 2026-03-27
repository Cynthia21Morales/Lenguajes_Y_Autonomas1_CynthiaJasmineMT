package com.jasminesystems.analizadorsintactico.gramatica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gramatica {

    private List<Produccion> producciones;

    public Gramatica() {
        producciones = new ArrayList<>();
        inicializar();
    }

    private void inicializar() {

        // declaracion → int id = expresion ;
        producciones.add(new Produccion("DECLARACION",
                Arrays.asList("int", "id", "=", "EXPRESION", ";")));

        // expresion → num + num
        producciones.add(new Produccion("EXPRESION",
                Arrays.asList("num", "+", "num")));

        // expresion → num
        producciones.add(new Produccion("EXPRESION",
                Arrays.asList("num")));
    }

    public List<Produccion> getProducciones() {
        return producciones;
    }

    public void mostrar() {
        for (Produccion p : producciones) {
            System.out.println(p);
        }
    }
}