public class Executable {
    public static void main(String[] args) {
        Stock stock = new Stock();

        Fournisseur fournisseurMoteur = new FournisseurMoteur(stock);
        Fournisseur fournisseurCarrosserie = new FournisseurCarrosserie(stock);
        Fournisseur fournisseurRoue = new FournisseurRoue(stock);

        Assembleur assembleur = new Assembleur(stock);

        fournisseurMoteur.start();
        fournisseurCarrosserie.start();
        fournisseurRoue.start();
        assembleur.start();
    }
}
