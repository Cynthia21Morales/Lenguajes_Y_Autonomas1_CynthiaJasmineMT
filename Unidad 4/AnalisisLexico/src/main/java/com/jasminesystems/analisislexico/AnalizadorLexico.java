package com.jasminesystems.analisislexico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalizadorLexico {

    private static final List<String> palabrasClave = Arrays.asList(
            "int", "float", "if", "else", "while", "for", "return"
    );

    private List<Token> tokens;
    private List<ErrorLexico> errores;

    public AnalizadorLexico() {
        tokens = new ArrayList<>();
        errores = new ArrayList<>();
    }

    public void analizar(String codigo) {
        tokens.clear();
        errores.clear();

        int i = 0;
        while (i < codigo.length()) {
            char c = codigo.charAt(i);

            // Ignorar espacios y saltos de línea
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            // Identificadores y palabras clave
            if (Character.isLetter(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < codigo.length() && (Character.isLetterOrDigit(codigo.charAt(i)) || codigo.charAt(i) == '_')) {
                    sb.append(codigo.charAt(i));
                    i++;
                }
                String palabra = sb.toString();
                if (palabrasClave.contains(palabra)) {
                    tokens.add(new Token(palabra, "Palabra clave"));
                } else {
                    tokens.add(new Token(palabra, "Identificador"));
                }
                continue;
            }

            // Números (enteros y decimales)
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                boolean punto = false;
                while (i < codigo.length() && (Character.isDigit(codigo.charAt(i)) || codigo.charAt(i) == '.')) {
                    if (codigo.charAt(i) == '.') {
                        if (punto) break; // solo un punto permitido
                        punto = true;
                    }
                    sb.append(codigo.charAt(i));
                    i++;
                }
                tokens.add(new Token(sb.toString(), "Número"));
                continue;
            }

            // Operadores y separadores
            switch (c) {
                case '+', '-', '*', '/', '=' -> tokens.add(new Token(Character.toString(c), "Operador"));
                case ';', ',' -> tokens.add(new Token(Character.toString(c), "Separador"));
                case '(', ')' -> tokens.add(new Token(Character.toString(c), "Paréntesis"));
                case '{', '}' -> tokens.add(new Token(Character.toString(c), "Llave"));
                default -> errores.add(new ErrorLexico(Character.toString(c), i));
            }

            i++;
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public List<ErrorLexico> getErrores() {
        return errores;
    }
}