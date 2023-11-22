public class MatriceThread extends Thread {
    private Matrice m1, m2, resultat;
    private int ligne;

    public MatriceThread(Matrice m1, Matrice m2, Matrice resultat, int ligne) {
        this.m1 = m1;
        this.m2 = m2;
        this.resultat = resultat;
        this.ligne = ligne;
    }

    @Override
    public void run() {
        for (int j = 0; j < resultat.getTaille(); j++) {
            for (int k = 0; k < resultat.getTaille(); k++) {
                resultat.setElement(ligne, j, resultat.getElement(ligne, j) + m1.getElement(ligne, k) * m2.getElement(k, j));
            }
        }
    }
}