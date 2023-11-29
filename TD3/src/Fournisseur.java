public class Fournisseur extends Thread {

    private Stock stock;
    private String pieceType;

    public Fournisseur(Stock stock, String pieceType) {
        this.stock = stock;
        this.pieceType = pieceType;
    }

    @Override
    public void run() {
        System.out.println("Fournisseur de " + pieceType + " : Démarré.");
        while (true) {
            produirePiece();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produirePiece() {
        try {
            if ("Moteur".equals(pieceType)) {
                stock.ajouterMoteur(pieceType);
                System.out.println("Fournisseur de Moteur : Moteur ajouté au stock.");
            } else if ("Carrosserie".equals(pieceType)) {
                stock.ajouterCarrosserie(pieceType);
                System.out.println("Fournisseur de Carrosserie : Carrosserie ajoutée au stock.");
            } else if ("Roue".equals(pieceType)) {
                stock.ajouterRoue(pieceType);
                System.out.println("Fournisseur de Roue : Roue ajoutée au stock.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
