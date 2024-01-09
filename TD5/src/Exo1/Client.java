package Exo1;
import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",4444);
            InputStreamReader stream =
            new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(stream);
            String message = reader.readLine();
            socket.close();
            System.out.println(socket.getOutputStream());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}