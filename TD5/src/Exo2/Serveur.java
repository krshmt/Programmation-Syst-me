import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Serveur {
    public static void main(String[] args) {
        Sondage sondage = new Sondage();
        List<String> proposition = new ArrayList<>();
        proposition.add("/vote");
        proposition.add("/resultat");
        try {
            ServerSocket socketServer = new ServerSocket(4445);
            while (true) {
                Socket socketClient = socketServer.accept();
                PrintWriter writer = new PrintWriter(socketClient.getOutputStream(), true);
                System.out.println("Client connecté");
                
                System.out.println("Liste des commandes : ");
                for(String prop : proposition){
                    writer.println(prop);
                }

                InputStreamReader stream = new InputStreamReader(socketClient.getInputStream());
                BufferedReader reader = new BufferedReader(stream);
                String message = reader.readLine();

                if (message.equals("/vote")) {
                    sondage.afficherCandidates();
                    writer.println(sondage.afficherCandidates());
                    writer.println("Veuillez choisir un candidat");
                    String message2 = reader.readLine();
                    sondage.voterCandidat(message2);
                }
                else if (message.equals("/resultat")) {
                    String vainqueur = sondage.candidatVainqueur();
                    writer.println("Le vainqueur est : " + vainqueur);
                }
                else {
                    System.out.println("Commande inconnue");
                }
                socketClient.close();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}