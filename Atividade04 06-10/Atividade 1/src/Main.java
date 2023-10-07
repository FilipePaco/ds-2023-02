import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Eduardo", "Ferreira", 20, 9.5, 8.0));
        students.add(new Student("Fernanda", "Santos", 22, 8.0, 7.5));
        students.add(new Student("Gustavo", "Oliveira", 19, 7.5, 8.5));

        System.out.println("Lista de estudantes desordenada:");
        students.forEach(System.out::println);

        // Ordenar por nome em ordem alfabética
        Ordenador.ordenarPorNome(students);
        System.out.println("\nOrdenado por nome:");
        students.forEach(System.out::println);

        // Ordenar por sobrenome em ordem alfabética
        Ordenador.ordenarPorSobrenome(students);
        System.out.println("\nOrdenado por sobrenome:");
        students.forEach(System.out::println);

        // Ordenar por idade
        Ordenador.ordenarPorIdade(students);
        System.out.println("\nOrdenado por idade:");
        students.forEach(System.out::println);

        // Ordenar por nota
        Ordenador.ordenarPorNota(students);
        System.out.println("\nOrdenado por nota:");
        students.forEach(System.out::println);

        // Ordenar por média
        Ordenador.ordenarPorMedia(students);
        System.out.println("\nOrdenado por média:");
        students.forEach(System.out::println);
    }
}
