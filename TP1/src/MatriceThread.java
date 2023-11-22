public class MatriceThread extends Thread {
    private Matrice m1, m2, resultat;
    private int debut, fin;

    public MatriceThread(Matrice m1, Matrice m2, Matrice resultat, int debut, int fin) {
        this.m1 = m1;
        this.m2 = m2;
        this.resultat = resultat;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = debut; i < fin; i++) {
            for (int j = 0; j < resultat.getTaille(); j++) {
                for (int k = 0; k < resultat.getTaille(); k++) {
                    resultat.setElement(i, j,
                            resultat.getElement(i, j) + m1.getElement(i, k) * m2.getElement(k, j));
                }
            }
        }
    }
}