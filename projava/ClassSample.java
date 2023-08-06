package projava;

public class ClassSample {
    /**
     * Student
     */
    public record Student(String name, int score) {
    }

    public static void main(String[] args) {
        var s = new Student("yamamoto", 80);
        System.out.println(s);
    }
}
