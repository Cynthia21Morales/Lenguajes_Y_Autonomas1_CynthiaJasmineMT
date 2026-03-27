package com.jasminesystems.maquinaturing.logica;

import com.jasminesystems.maquinaturing.modelo.MaquinaTuring2D;
import com.jasminesystems.maquinaturing.modelo.Transicion;

/*
 * Ejecuta la lógica de la máquina paso a paso
 */
public class SimuladorTuring2D {

    private MaquinaTuring2D maquina;

    public SimuladorTuring2D(MaquinaTuring2D maquina) {
        this.maquina = maquina;
    }

    /*
     * Ejecuta un solo paso de la máquina:
     * 1. Lee símbolo
     * 2. Busca transición
     * 3. Escribe
     * 4. Cambia estado
     * 5. Mueve cabezal
     */
    public void paso() {

        // Leer símbolo actual
        char simbolo = maquina.cinta[maquina.fila][maquina.columna];

        // Buscar transición válida
        for (Transicion t : maquina.transiciones) {

            if (t.estadoActual.equals(maquina.estadoActual)
                    && t.simboloLeido == simbolo) {

                // Escribir nuevo símbolo
                maquina.cinta[maquina.fila][maquina.columna] = t.simboloEscrito;

                // Cambiar estado
                maquina.estadoActual = t.siguienteEstado;

                // Mover cabezal
                switch (t.movimiento) {
                    case "ARRIBA" -> maquina.fila--;
                    case "ABAJO" -> maquina.fila++;
                    case "IZQ" -> maquina.columna--;
                    case "DER" -> maquina.columna++;
                }

                return; // Termina el paso
            }
        }
    }
}