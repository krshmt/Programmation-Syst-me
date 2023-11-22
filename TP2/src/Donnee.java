public class Donnee {
    private String data;

    public Donnee() {
    }

    public synchronized void ajouter(String data) {
        while (this.data != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Interruption pendant l'attente : " + e.getMessage());
            }
        }
        this.data = data;
        notify();
    }

    public synchronized String recuperer() {
        while (this.data == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Interruption pendant l'attente : " + e.getMessage());
            }
        }
        String variable = this.data;
        this.data = null;
        notify();
        return variable;
    }
}
