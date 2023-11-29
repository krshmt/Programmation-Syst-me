import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ressource {
    private String contenu;
    private final Lock lock;
    private Condition condition;

    public Ressource(String contenu) {
        this.contenu = contenu;
        this.lock = new ReentrantLock();
        this.condition = this.lock.newCondition();
    }

    public void lire() throws InterruptedException {
        lock.lock();
        try {
            while(this.contenu.equals("")){
                this.condition.await();
            }
            System.out.println(this.contenu);
        } finally {
            lock.unlock();
        }
    }

    public void ecrire(String texte) throws InterruptedException {
        lock.lock();
        try {
            this.contenu += texte;
            this.condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
