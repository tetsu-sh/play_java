package projava;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(1600)) {
            System.out.println("Server is waiting ...");
            Socket socket = server.accept();
            System.out.println("connect from " + socket.getInetAddress());
            InputStream input = socket.getInputStream();
            System.out.println(input.read());
            input.close();
            socket.close();
        }
    }
}
