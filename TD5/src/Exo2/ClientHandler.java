import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientHandler extends Thread {
    private Socket socketClient;
    private Sondage sondage;
    private List<String> proposition;

    public ClientHandler(Socket socketClient, Sondage sondage, List<String> proposition) {
        this.socketClient = socketClient;
        this.sondage = sondage;
        this.proposition = proposition;
    }

    @Override
public void run() {
    try {
        PrintWriter writer = new PrintWriter(socketClient.getOutputStream(), true);
        System.out.println("Client connecté");

        System.out.println("Liste des commandes : ");
        for (String prop : proposition) {
            writer.println(prop);
        }

        InputStreamReader stream = new InputStreamReader(socketClient.getInputStream());
        BufferedReader reader = new BufferedReader(stream);
        String message = reader.readLine();
        sondage.afficherCandidates();

        if (message.startsWith("/vote ")) {
            String[] message2 = message.split(" ");
            String message3 = message2[1];
            sondage.voterCandidat(message3);
            
        } else if (message.equals("/resultat")) {
            String vainqueur = sondage.candidatVainqueur();
            writer.println("Le vainqueur est : " + vainqueur);
        } else {
            System.out.println("Commande inconnue");
        }

        socketClient.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
