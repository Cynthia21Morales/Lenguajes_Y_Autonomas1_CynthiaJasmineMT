package com.jasminesystems.analisislexico;

import java.util.ArrayList;
import java.util.List;

public class TablaTokens {
    private List<Token> tokens;

    public TablaTokens() {
        tokens = new ArrayList<>();
    }

    public void agregarToken(Token token) {
        tokens.add(token);
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void limpiar() {
        tokens.clear();
    }
}