package com.jasminesystems.analizadorsintactico.sintactico;

import com.jasminesystems.analizadorsintactico.lexico.*;

import java.util.List;

public class AnalizadorSintactico {

    private List<Token> tokens;
    private int pos = 0;

    public AnalizadorSintactico(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void analizar() {
        declaracion();
        match(TipoToken.EOF);
    }

    private void declaracion() {
        match(TipoToken.INT);
        match(TipoToken.ID);
        match(TipoToken.IGUAL);
        expresion();
        match(TipoToken.PUNTO_COMA);
    }

    // expresion con operadores y paréntesis
    private void expresion() {
        termino();

        while (ver(TipoToken.MAS) || ver(TipoToken.MENOS)) {
            avanzar();
            termino();
        }
    }

    private void termino() {
        factor();

        while (ver(TipoToken.MULT) || ver(TipoToken.DIV)) {
            avanzar();
            factor();
        }
    }

    private void factor() {
        if (ver(TipoToken.NUM)) {
            match(TipoToken.NUM);
        } else if (ver(TipoToken.PAR_IZQ)) {
            match(TipoToken.PAR_IZQ);
            expresion();
            match(TipoToken.PAR_DER);
        } else {
            throw new ErrorSintactico("Se esperaba número o '(' pero se encontró: " + actual().lexema);
        }
    }

    private void match(TipoToken esperado) {
        if (actual().tipo == esperado) {
            pos++;
        } else {
            throw new ErrorSintactico(
                    "Se esperaba " + esperado + " pero se encontró '" + actual().lexema + "'"
            );
        }
    }

    private boolean ver(TipoToken tipo) {
        return actual().tipo == tipo;
    }

    private void avanzar() {
        pos++;
    }

    private Token actual() {
        return tokens.get(pos);
    }
}