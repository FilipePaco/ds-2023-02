package com.example;
// Interface que define o contrato para as expressões
interface Expressao {
    float valor();
}

// Classe que representa uma constante
class Constante implements Expressao {
    private float valor;

    public Constante(float valor) {
        this.valor = valor;
    }

    @Override
    public float valor() {
        return valor;
    }
}

// Classe abstrata para operações multiárias
abstract class OperacaoMultiaria implements Expressao {
    protected Expressao[] operandos;

    public OperacaoMultiaria(Expressao... operandos) {
        this.operandos = operandos;
    }
}

// Classes para operações específicas
class Soma extends OperacaoMultiaria {
    public Soma(Expressao... operandos) {
        super(operandos);
    }

    @Override
    public float valor() {
        float resultado = 0;
        for (Expressao operando : operandos) {
            resultado += operando.valor();
        }
        return resultado;
    }
}

class Multiplica extends OperacaoMultiaria {
    public Multiplica(Expressao... operandos) {
        super(operandos);
    }

    @Override
    public float valor() {
        float resultado = 1;
        for (Expressao operando : operandos) {
            resultado *= operando.valor();
        }
        return resultado;
    }
}

public class Main {
    public static void main(String[] args) {
        Expressao expressao = new Soma(new Constante(5), new Multiplica(new Constante(7), new Constante(3)), new Constante(2));
        System.out.println("O valor da expressão é: " + expressao.valor()); // Deve resultar em 28.0
    }
}
