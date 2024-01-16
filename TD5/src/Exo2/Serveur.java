import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Serveur {
    private static final int PORT = 4445;
    private static Sondage sondage = new Sondage();
    private static List<String> proposition = new ArrayList<>();

    static {
        proposition.add("/vote");
        proposition.add("/resultat");
    }

    public static void main(String[] args) {
        try {
            ServerSocket socketServer = new ServerSocket(PORT);
            System.out.println("Serveur démarré sur le port " + PORT);

            while (true) {
                Socket socketClient = socketServer.accept();
                System.out.println("Nouvelle connexion client");

                ClientHandler clientHandler = new ClientHandler(socketClient, sondage, proposition);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
