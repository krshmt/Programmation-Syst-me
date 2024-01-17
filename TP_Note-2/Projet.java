import java.util.ArrayList;
import java.util.List;

public class Projet {
    private String nom;
    private List<String> taches;
    private List<String> tachesRealisees;

    public Projet(List<String> taches, String nom) {
        this.nom = nom;
        this.taches = new ArrayList<>(taches);
        this.tachesRealisees = new ArrayList<>();
    }

    public List<String> getTachesRealisees() {
        return tachesRealisees;
    }

    public List<String> getTaches() {
        return taches;
    }

    public synchronized String getProchaineTache() {
        if (taches.isEmpty()) {
            return null;
        }
        String prochaineTache = taches.remove(0);
        return prochaineTache;
    }

    public synchronized void ajouterTacheRealisee(String tache) {
        tachesRealisees.add(tache);
    }

    public boolean tachesRestantes() {
        return !taches.isEmpty();
    }

    public String getNom() {
        return nom;
    }
}
