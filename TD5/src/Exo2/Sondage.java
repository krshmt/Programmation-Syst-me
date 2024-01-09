import java.util.concurrent.ConcurrentHashMap;

public class Sondage {
    private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();

    public Sondage() {
        this.map.put("Macrom", 1220120);
        this.map.put("Mélanchon", 254855);
        this.map.put("Le Pen", 784546);
        this.map.put("Dupont", 9869);
        this.map.put("Boulay", 667);
    }

    public String afficherCandidates() {
        //retourner en string toutes les clés de la map
        String res = "";
        for (String key : this.map.keySet()) {
            res += key + " ";
        }
        return res;
    }

    public void voterCandidat(String nomCandidat) {
        if (this.map.containsKey(nomCandidat)) {
            this.map.put(nomCandidat, this.map.get(nomCandidat) + 1);
            System.out.println("Vote enregistré");
        }
        System.out.println("Vote non enregistré car candidat " + nomCandidat + " est inconnu");
    }

    public String candidatVainqueur() {
        String vainqueur = "";
        int max = 0;
        for (String key : this.map.keySet()) {
            if (this.map.get(key) > max) {
                max = this.map.get(key);
                vainqueur = key;
            }
        }
        return vainqueur;
    }
}
