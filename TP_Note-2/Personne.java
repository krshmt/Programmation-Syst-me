import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Personne implements Runnable {
    private String nom;
    private List<Projet> projets;
    private CyclicBarrier barrier;

    public Personne(String nom, List<Projet> projets, CyclicBarrier barrier) {
        this.nom = nom;
        this.projets = projets;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        for (Projet projet : projets) {
            System.out.println( "Commencement du projet : " + projet.getNom() );

            while (projet.tachesRestantes()) {
                String tache = projet.getProchaineTache();
                if (tache != null) {
                    System.out.println( nom + " commence la tâche : " + tache );

                    try {
                        Thread.sleep(new Random().nextInt(3000) + 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    projet.ajouterTacheRealisee(tache);
                    System.out.println( nom + " a terminé la tâche : " + tache );
                    System.out.println("Tâches réalisées : " + projet.getTachesRealisees().toString());

                    try {
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("fin du projet " + projet.getNom());

            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
