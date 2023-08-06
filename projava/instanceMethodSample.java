package projava;

import java.util.stream.Stream;

public class instanceMethodSample {
    record Student(String name, int englishScore,int mathScore){
        int average(){
            return (this.englishScore+this.mathScore)/2;
        }

        public int maxScore() {
            return Math.max(this.englishScore,this.mathScore);
        }
    }
    
    public static void main(String[] args) {
        var k = new Student("kis",60,80);
        System.out.println("avarage is %d".formatted(k.average())); 
        k.maxScore();
        Stream.of("apple","grape").mapToInt(String::length).toArray();
    }

}
