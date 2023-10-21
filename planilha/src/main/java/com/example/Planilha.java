package com.example;

import java.util.HashMap;
import java.util.Map;

public class Planilha {
    private Map<String, Celula> celulas;

    public Planilha() {
        celulas = new HashMap<>();
    }

    public Celula criarCelula(String nome, int valor) {
        Celula novaCelula = new Celula(nome, valor);
        celulas.put(nome, novaCelula);
        return novaCelula;
    }

    public Celula getCelula(String nome) {
        return celulas.get(nome);
    }
}
