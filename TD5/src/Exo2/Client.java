import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 4445);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Lire et afficher la liste des commandes
            String command;
            while ((command = reader.readLine()) != null) {
                System.out.println(command);
            }

            // Demander à l'utilisateur de choisir une commande
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Veuillez choisir une commande : ");
            String userChoice = userInputReader.readLine();
            writer.println(userChoice);

            // Si l'utilisateur choisit "/vote", afficher la liste des candidats et voter
            if ("/vote".equals(userChoice)) {
                String candidates = reader.readLine();
                System.out.println("Liste des candidats : " + candidates);

                System.out.print("Veuillez choisir un candidat : ");
                String candidatChoice = userInputReader.readLine();
                writer.println(candidatChoice);

                // Attendre la réponse du serveur après le vote
                String voteResponse = reader.readLine();
                System.out.println(voteResponse);
            }
            // Si l'utilisateur choisit "/resultat", afficher le résultat
            else if ("/resultat".equals(userChoice)) {
                // Attendre la réponse du serveur avec le résultat
                String resultat = reader.readLine();
                System.out.println(resultat);
            } else {
                System.out.println("Commande inconnue");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
