package com.example;

// Interface Markdown
interface Markdown {
    void exibe();
}

// Classe Texto
class Texto implements Markdown {
    private String texto;

    public Texto(String texto) {
        this.texto = texto;
    }

    public void exibe() {
        System.out.print(texto);
    }
}

// Classe Decorator base
class Decorator implements Markdown {
    private Markdown markdown;

    public Decorator(Markdown markdown) {
        this.markdown = markdown;
    }

    public void exibe() {
        markdown.exibe();
    }
}

// Classe Negrito
class Negrito extends Decorator {
    public Negrito(Markdown markdown) {
        super(markdown);
    }

    public void exibe() {
        System.out.print("**");
        super.exibe();
        System.out.print("**");
    }
}

// Classe Italico
class Italico extends Decorator {
    public Italico(Markdown markdown) {
        super(markdown);
    }

    public void exibe() {
        System.out.print("_");
        super.exibe();
        System.out.print("_");
    }
}

// Classe Titulo
class Titulo extends Decorator {
    public Titulo(Markdown markdown) {
        super(markdown);
    }

    public void exibe() {
        System.out.println("# ");
        super.exibe();
    }
}

// Classe Item
class Item extends Decorator {
    public Item(Markdown markdown) {
        super(markdown);
    }

    public void exibe() {
        System.out.print("- ");
        super.exibe();
        System.out.println();
    }
}

// Classe Concatena
class Concatena implements Markdown {
    private Markdown markdown1;
    private Markdown markdown2;

    public Concatena(Markdown markdown1, Markdown markdown2) {
        this.markdown1 = markdown1;
        this.markdown2 = markdown2;
    }

    public void exibe() {
        markdown1.exibe();
        markdown2.exibe();
    }
}

public class Main {
    public static void main(String[] args) {
        Markdown titulo = new Titulo(new Texto("Título"));
        Markdown linha = new Texto("Uma simples linha, com ");
        Markdown negrito = new Negrito(new Texto("negrito"));
        Markdown italico = new Italico(new Texto("itálico"));
        Markdown item = new Item(new Italico(new Texto("Primeiro item da linha com itálico.")));

        Markdown mensagem = new Concatena(titulo, new Concatena(linha, new Concatena(negrito, new Concatena(new Texto(" e "), new Concatena(italico, item)))));
        mensagem.exibe();
    }
}
