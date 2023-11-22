public class Matrice{
    
    private Integer taille;
    private int[][]tab;

    public Matrice(Integer taille){
        this.taille = taille;
        this.tab = new int[taille][taille];
    }

    public int getTaille(){
        return this.taille;
    }

    public int getElement(int i, int j) {
        return tab[i][j];
    }

    public void setElement(int i, int j, int value) {
        tab[i][j] = value;
    }

    public int[][] init() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                this.tab[i][j] = (int) (Math.random() * 10);
            }
        }
        return this.tab;
    }

    public void printMatrix() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Matrice multiplier(Matrice m) {
        Matrice resultat = new Matrice(taille);
        
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                for (int k = 0; k < taille; k++) {
                    resultat.tab[i][j] += this.tab[i][k] * m.tab[k][j];
                }
            }
        }
        return resultat;
    }

    public Matrice multiplicationParrallele(Matrice m) {
        Matrice resultat = new Matrice(taille);
        MatriceThread[] threads = new MatriceThread[taille];

        for (int i = 0; i < taille; i++) {
            threads[i] = new MatriceThread(this, m, resultat, i);
            threads[i].start();
        }
        return resultat;
    }

}