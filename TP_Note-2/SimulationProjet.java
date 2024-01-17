import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class SimulationProjet {

    public static void main(String[] args) {
        List<String> tachesProjet1 = List.of("Conception de la base de données", "Développement de l'application", "Tests", "Rédaction de la documentation", "Soutenance", "Répondre aux questions du jury");
        List<String> tachesProjet2 = List.of("Conception de la messagerie", "Conception de la connexion Client/Serveur", "Ajout des fonctionnalités", "Tests", "Rédaction de la documentation", "Soutenance", "Répondre aux questions du jury");

        Projet projet1 = new Projet(tachesProjet1, "Analyse");
        Projet projet2 = new Projet(tachesProjet2, "Développement WEB");

        CyclicBarrier barrier1 = new CyclicBarrier(3);

        List<Projet> projets = List.of(projet1, projet2);

        Thread personne1 = new Thread(new Personne("Kylian", projets, barrier1));
        Thread personne2 = new Thread(new Personne("Marc", projets, barrier1));
        Thread personne3 = new Thread(new Personne("Julie", projets, barrier1));

        personne1.start();
        personne2.start();
        personne3.start();
    }
}
