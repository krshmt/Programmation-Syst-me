import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileAttente {
    private final List<String> file = new ArrayList<>();
    private final int tailleMax;
    private final Lock lock = new ReentrantLock();
    private Condition attente = lock.newCondition();

    public FileAttente(int tailleMax) {
        this.tailleMax = tailleMax;
    }

    public void ajouter(String document) throws InterruptedException {
        lock.lock();
        try {
            while (file.size() >= tailleMax) {
                attente.await();
            }
            file.add(document);
            attente.signalAll(); 
        } finally {
            lock.unlock();
        }
    }

    public void supprimer(String document) throws InterruptedException {
        lock.lock();
        try {
            while (file.isEmpty() || !file.contains(document)) {
                attente.await();
            }
            file.remove(document);
            attente.signalAll(); 
        } finally {
            lock.unlock();
        }
    }
}
