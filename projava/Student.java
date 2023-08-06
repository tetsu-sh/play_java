package projava;

public class Student {
    private final String name;
    private final int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;

    }

    public String name() {
        return this.name;
    }

    public int score() {
        return this.score;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public String toString() {
        return String.format("Student(name=%s, score=%d)", this.name, this.score);
    }


}
