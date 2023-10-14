package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CelulaTest {

    @Test
    public void testNotificacaoSimples() {
        Planilha planilha = new Planilha();
        Celula a1 = planilha.criarCelula("A1", 10);
        Celula a2 = planilha.criarCelula("A2", 20);
        Celula a3 = planilha.criarCelula("A3", 0);

        a3.adicionarObservadora(a1);

        a1.atualizarValor(15);

        assertEquals(25, a3.getValor()); // A3 deve ser notificada e atualizada para 25
    }

    @Test
    public void testNotificacaoDupla() {
        Planilha planilha = new Planilha();
        Celula a1 = planilha.criarCelula("A1", 10);
        Celula a2 = planilha.criarCelula("A2", 20);
        Celula a3 = planilha.criarCelula("A3", 0);

        a3.adicionarObservadora(a1);
        a3.adicionarObservadora(a2);

        a1.atualizarValor(15);

        assertEquals(45, a3.getValor()); // A3 deve ser notificada e atualizada para 45
    }

    @Test
    public void testNotificacaoCircular() {
        Planilha planilha = new Planilha();
        Celula a1 = planilha.criarCelula("A1", 10);
        Celula a2 = planilha.criarCelula("A2", 20);
        Celula a3 = planilha.criarCelula("A3", 0);

        a1.adicionarObservadora(a2);
        a2.adicionarObservadora(a1);

        a1.atualizarValor(15);

        assertEquals(25, a3.getValor()); // A3 deve ser notificada e atualizada para 25
    }
}
