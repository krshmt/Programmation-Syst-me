import java.util.Random;

class Consommateur implements Runnable {
    private Donnee file;
    private Random random = new Random();

    public Consommateur(Donnee file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(random.nextInt(1000));
                String contenu = file.recuperer();
                System.out.println("Consommé : " + contenu);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
