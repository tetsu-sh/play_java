package projava;

import java.util.List;

public class InheritSample {
    static abstract class User {
        String name;

        User(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        abstract String profile();
    }

    static class Student extends User {
        int score;

        Student(String name, int score) {
            super(name);
            this.score = score;

        }

        public int getScore() {
            return this.score;
        }

        @Override
        public String toString() {
            return "%sの%s".formatted(getClass().getSimpleName(), getName());
        }

        @Override
        String profile() {
            return "Student %s, %d".formatted(getName(), getScore());
        }


    }
    static class Teacher extends User {
        String subject;

        Teacher(String name, String subject) {
            super(name);
            this.subject = subject;
        }

        String getSubject() {
            return this.subject;
        }

        @Override
        String profile() {
            return "Teacher %s, subject: %s".formatted(getName(), getSubject());
        }
    }

    public static void main(String[] args) {
        List<User> people = List.of(new User("anonymous") {
            @Override
            String profile() {
                return "anonymous";
            }

        }, new Student("pipe", 80), new Teacher("hosoya", "math"));
        for (var p : people) {
            System.out.println("hello %s".formatted(p.getName()));
        }
    }
}
