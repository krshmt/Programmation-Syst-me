import java.util.Random;

class Imprimante extends Thread {
    private final FileAttente fileAttente;
    private final String documentType;
    private int numeroImprimante;

    public Imprimante(int numeroImprimante, FileAttente fileAttente, String documentType) {
        this.fileAttente = fileAttente;
        this.documentType = documentType;
        this.numeroImprimante = numeroImprimante;
    }

    @Override
    public void run() {
        while (true) {
            try {
                fileAttente.supprimer(documentType); 
                System.out.println("Imprimante "+ numeroImprimante + "a récupéré un document " + documentType + ", impression en cours ");
                Thread.sleep(new Random().nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println("Imprimante " + numeroImprimante + " a terminé l'impression du document " + documentType);
            }
        }
    }
}
