import java.util.Random;

public class Application extends Thread {
    private final FileAttente fileAttente;
    private final String documentType;
    private int numeroApplication;

    public Application(int numeroApplication, FileAttente fileAttente, String documentType) {
        this.fileAttente = fileAttente;
        this.documentType = documentType;
        this.numeroApplication = numeroApplication;
    }

    @Override
    public void run() {
        while(true) {
            String document = documentType;
            try {
                fileAttente.ajouter(document);
                System.out.println("Application " + numeroApplication + " a fait une demande d'impression du document " + document);
                Thread.sleep(new Random().nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }
    }
}
