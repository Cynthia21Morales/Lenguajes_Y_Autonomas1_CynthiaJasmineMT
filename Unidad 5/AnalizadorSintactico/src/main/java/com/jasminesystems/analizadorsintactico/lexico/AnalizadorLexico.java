package com.jasminesystems.analizadorsintactico.lexico;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorLexico {

    private String entrada;
    private int pos = 0;

    public AnalizadorLexico(String entrada) {
        this.entrada = entrada;
    }

    public List<Token> analizar() {
        List<Token> tokens = new ArrayList<>();

        while (pos < entrada.length()) {
            char c = entrada.charAt(pos);

            if (Character.isWhitespace(c)) {
                pos++;
                continue;
            }

            if (Character.isDigit(c)) {
                tokens.add(numero());
                continue;
            }

            if (Character.isLetter(c)) {
                tokens.add(identificador());
                continue;
            }

            switch (c) {
                case '=' -> tokens.add(new Token(TipoToken.IGUAL, "="));
                case '+' -> tokens.add(new Token(TipoToken.MAS, "+"));
                case '-' -> tokens.add(new Token(TipoToken.MENOS, "-"));
                case '*' -> tokens.add(new Token(TipoToken.MULT, "*"));
                case '/' -> tokens.add(new Token(TipoToken.DIV, "/"));
                case '(' -> tokens.add(new Token(TipoToken.PAR_IZQ, "("));
                case ')' -> tokens.add(new Token(TipoToken.PAR_DER, ")"));
                case ';' -> tokens.add(new Token(TipoToken.PUNTO_COMA, ";"));
                default -> throw new RuntimeException("Error léxico: símbolo inválido '" + c + "'");
            }
            pos++;
        }

        tokens.add(new Token(TipoToken.EOF, ""));
        return tokens;
    }

    private Token numero() {
        StringBuilder sb = new StringBuilder();
        while (pos < entrada.length() && Character.isDigit(entrada.charAt(pos))) {
            sb.append(entrada.charAt(pos++));
        }
        return new Token(TipoToken.NUM, sb.toString());
    }

    private Token identificador() {
        StringBuilder sb = new StringBuilder();
        while (pos < entrada.length() && Character.isLetterOrDigit(entrada.charAt(pos))) {
            sb.append(entrada.charAt(pos++));
        }

        String palabra = sb.toString();
        if (palabra.equals("int")) return new Token(TipoToken.INT, palabra);

        return new Token(TipoToken.ID, palabra);
    }
}