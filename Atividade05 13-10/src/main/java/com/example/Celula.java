package com.example;

import java.util.ArrayList;
import java.util.List;

public class Celula {
    private String nome;
    private int valor;
    private List<Celula> observadoras;

    public Celula(String nome, int valor) {
        this.nome = nome;
        this.valor = valor;
        this.observadoras = new ArrayList<>();
    }

    public void adicionarObservadora(Celula observadora) {
        observadoras.add(observadora);
    }

    public void atualizarValor(int novoValor) {
        if (valor != novoValor) {
            System.out.println("Reavaliar " + nome + " por mudança ocorrida em " + nome);
            valor = novoValor;
            notificarObservadoras();
        }
    }

    private void notificarObservadoras() {
        for (Celula observadora : observadoras) {
            observadora.atualizarValor(observadora.calcularNovoValor());
        }
    }

    public int calcularNovoValor() {
        int novoValor = valor;

        for (Celula observada : observadoras) {
            novoValor += observada.getValor();
        }

        return novoValor;
    }

    public int getValor() {
        return valor;
    }
}



