package projava;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamSample2 {
    public static void main(String[] args) {
        var data = List.of("yaamoto", "kis", "sugiyama");
        var result=data.stream().filter(s->s.length()>5).collect(Collectors.toList());

        data.stream().forEach(s->System.out.println(s));
        var o=Optional.of("a");
        o.map(null).orElse("b");
        var nums=new int[]{2,5,3};
        IntStream.of(nums).sum();
        IntStream.iterate(0, i->i+1).limit(10).toArray();
        var r= new Random();
        r.ints(10, 0, 3).toArray();
        
        
    }
    static int twice(int x){
        return x*2;
    }
    
}

