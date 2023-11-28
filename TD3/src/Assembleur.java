public class Assembleur extends Thread {

    private Stock stock;

    public Assembleur(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        System.out.println("Assembleur : Démarré.");
        while (true) {
            assemblerVoiture();
            try {
                Thread.sleep(1000); // Simule le temps nécessaire pour assembler une voiture
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void assemblerVoiture() {
        try {
            stock.recupererRoue("Roue");
            stock.recupererMoteur("Moteur");
            stock.recupererCarrosserie("Carrosserie");
            System.out.println("Assembleur : Voiture assemblée !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Stock stock = new Stock();
        Assembleur assembleur = new Assembleur(stock);
        assembleur.start();
    }
}
