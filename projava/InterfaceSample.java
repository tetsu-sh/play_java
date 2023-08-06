package projava;

import java.util.List;
import java.util.function.Function;

public class InterfaceSample {
    interface Named {
        String pattern = "hello";

        String name();

        default String greeting() {
            return "hello%s".formatted(this.name());
        };

    }

    static Function<String, String> greeting2 = s -> "hello%s".formatted(s);

    static void message(Named named) {
        System.out.println("Hello " + named.name());
    }

    record Student(String name, int score) implements Named {
    }
    record Teacher(String name, String subject) implements Named {
    }
    static class Passenger implements Named {

        @Override
        public String name() {
            return "passenger";
        }


    }


    public static void main(String[] args) {
        var people =
                List.of(new Student("kis", 80), new Teacher("hosoya", "math"), new Passenger());
        for (Named p : people) {
            // var n = p instanceof Student s ? s.name() : p instanceof Teacher t ? t.name() :
            // "---";
            System.out.println("hello %s".formatted(p.name()));
        }
        message(() -> "no name");
        greeting2.apply("pppp");
    }

}

