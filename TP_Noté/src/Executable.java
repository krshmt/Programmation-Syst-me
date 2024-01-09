public class Executable {
    public static void main(String[] args) {
        FileAttente a4Queue = new FileAttente(5);
        FileAttente photoQueue = new FileAttente(5);
        FileAttente a3Queue = new FileAttente(5);

        Imprimante impressionA4 = new Imprimante(1,a4Queue, "A4");
        Imprimante impressionPhotos = new Imprimante(2,photoQueue, "Photo");
        Imprimante impressionA3 = new Imprimante(3,a3Queue, "A3");

        Application a4App = new Application(1,a4Queue, "A4");
        Application photoApp = new Application(2,photoQueue, "Photo");
        Application a3App = new Application(3,a3Queue, "A3");

        impressionA4.start();
        impressionPhotos.start();
        impressionA3.start();

        a4App.start();
        photoApp.start();
        a3App.start();
    }

}
