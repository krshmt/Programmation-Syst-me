import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Stock {

    private Map<String, Integer> data;
    private final Lock lock = new ReentrantLock();
    private Condition attente = lock.newCondition();

    public Stock() {
        this.data = new HashMap<>();
        this.data.put("Moteur", 0);
        this.data.put("Carrosserie", 0);
        this.data.put("Roue", 0);
    }

    public void ajouterMoteur(String key) throws InterruptedException {
        lock.lock();
        try {
            while (this.data.get(key) >= 5) {
                attente.await();
            }
            int valeurCle = this.data.get(key);
            this.data.put(key, valeurCle + 1);
            attente.signal();
        } finally {
            lock.unlock();
        }
    }

    public void recupererMoteur(String key) throws InterruptedException {
        lock.lock();
        try {
            while (this.data.get(key) == 0) {
                attente.await();
            }
            int valeurCle = this.data.get(key);
            this.data.put(key, valeurCle - 1);
            attente.signal();
        } finally {
            lock.unlock();
        }
    }

    public void ajouterCarrosserie(String key) throws InterruptedException {
        lock.lock();
        try {
            while (this.data.get(key) > 3) {
                attente.await();
            }
            int valeurCle = this.data.get(key);
            this.data.put(key, valeurCle + 1);
            attente.signal();
        } finally {
            lock.unlock();
        }
    }

    public void recupererCarrosserie(String key) throws InterruptedException {
        lock.lock();
        try {
            while (this.data.get(key) == 0) {
                attente.await();
            }
            int valeurCle = this.data.get(key);
            this.data.put(key, valeurCle - 1);
            attente.signal();
        } finally {
            lock.unlock();
        }
    }

    public void ajouterRoue(String key) throws InterruptedException {
        lock.lock();
        try {
            while (this.data.get(key) > 20) {
                attente.await();
            }
            int valeurCle = this.data.get(key);
            this.data.put(key, valeurCle + 1);
            attente.signal();
        } finally {
            lock.unlock();
        }
    }

    public void recupererRoue(String key) throws InterruptedException {
        lock.lock();
        try {
            while (this.data.get(key) < 4) {
                attente.await();
            }
            int valeurCle = this.data.get(key);
            this.data.put(key, valeurCle - 4);
            attente.signal();
        } finally {
            lock.unlock();
        }
    }
}
