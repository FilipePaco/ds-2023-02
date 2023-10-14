package com.example;

public class PlanilhaTest {
    public static void main(String[] args) {
        Planilha planilha = new Planilha();
        Celula a1 = planilha.criarCelula("A1", 10);
        Celula a2 = planilha.criarCelula("A2", 20);
        Celula a3 = planilha.criarCelula("A3", 0);

        a3.adicionarObservadora(a1);
        a3.adicionarObservadora(a2);

        a1.atualizarValor(15); // Isso deve acionar uma cadeia de notificações

        // Verifique se as notificações foram impressas corretamente
        // No exemplo, você pode apenas imprimir o valor da célula a3 após as notificações
        System.out.println("Novo valor de A3: " + a3.getValor());
    }
}
