import java.util.Comparator;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private double grade1;
    private double grade2;

    public Student(String firstName, String lastName, int age, double grade1, double grade2) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.grade1 = grade1;
        this.grade2 = grade2;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getAverageGrade() {
        return (grade1 + grade2) / 2;
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s %s', age=%d, grade1=%.1f, grade2=%.1f, averageGrade=%.1f}",
                firstName, lastName, age, grade1, grade2, getAverageGrade());
    }

    public static Comparator<Student> compareByFirstName = Comparator.comparing(Student::getFirstName);
    public static Comparator<Student> compareByLastName = Comparator.comparing(Student::getLastName);
    public static Comparator<Student> compareByAge = Comparator.comparingInt(Student::getAge);
    public static Comparator<Student> compareByGrade = Comparator.comparingDouble(student -> student.getAverageGrade());
    public static Comparator<Student> compareByMedia = Comparator.comparingDouble(Student::getAverageGrade);
}
