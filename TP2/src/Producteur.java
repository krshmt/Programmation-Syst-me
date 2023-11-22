import java.util.Random;

class Producteur implements Runnable {
    private Donnee file;
    private Random random = new Random();

    public Producteur(Donnee file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                String contenu = "Donnee_" + i;
                Thread.sleep(random.nextInt(1000));
                file.ajouter(contenu);
                System.out.println("Produit : " + contenu);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
