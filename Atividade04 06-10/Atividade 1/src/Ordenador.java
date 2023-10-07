import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class Ordenador {

    public static void ordenarPorNome(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getFirstName));
    }

    public static void ordenarPorSobrenome(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getLastName));
    }

    public static void ordenarPorIdade(List<Student> students) {
        Collections.sort(students, Comparator.comparingInt(Student::getAge));
    }

    public static void ordenarPorNota(List<Student> students) {
        Collections.sort(students, Comparator.comparingDouble(Student::getAverageGrade).reversed());
    }

    public static void ordenarPorMedia(List<Student> students) {
        Collections.sort(students, Comparator.comparingDouble(Student::getAverageGrade).reversed());
    }
}
