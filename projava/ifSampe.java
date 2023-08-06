package projava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ifSampe {
   public static void main(String[] args) {
        var a=5;
        if (a>3){
            System.out.println("a>3");
        }

        List<Integer> l = new ArrayList<>();
        l.add(3);
        var t= List.of(1,2,3,4);
        var s = new int[3];
        String[] weeks= {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        var el=new Exam("John","Math",90);        
        var m=new HashMap<String,String>();
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        for (int week = 0; week < weeks.length; week++) {
            
        }
        List<String> strs=List.of("a","b","c");
        for (String str : strs) {
            System.out.println(str);
        }
        
   } 
}

record Exam(String name, String subject,int score){

}
