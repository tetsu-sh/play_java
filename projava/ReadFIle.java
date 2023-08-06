package projava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class ReadFIle {
    public static void main(String[] args) throws IOException {
        try {
            var p = Path.of("test.txt");
            var message = Files.readString(p);
            System.out.println(message);
        } catch (NoSuchFileException e) {
            System.out.println(e.getFile());
        }
    }
}


