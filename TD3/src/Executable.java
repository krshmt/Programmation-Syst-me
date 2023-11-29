public class Executable {
    public static void main(String[] args) {
        Stock stock = new Stock();

        Fournisseur fournisseurMoteur = new Fournisseur(stock, "Moteur");
        Fournisseur fournisseurCarrosserie = new Fournisseur(stock, "Carrosserie");
        Fournisseur fournisseurRoue = new Fournisseur(stock, "Roue");

        Assembleur assembleur = new Assembleur(stock);

        fournisseurMoteur.start();
        fournisseurCarrosserie.start();
        fournisseurRoue.start();
        assembleur.start();
    }
}
