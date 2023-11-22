public class Main {
    public static void main(String[] args) {
        Donnee file = new Donnee();

        Producteur producteur = new Producteur(file);
        Consommateur consommateur = new Consommateur(file);

        Thread threadProducteur = new Thread(producteur);
        Thread threadConsommateur = new Thread(consommateur);

        threadProducteur.start();
        threadConsommateur.start();

        try {
            threadProducteur.join();
            threadConsommateur.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
