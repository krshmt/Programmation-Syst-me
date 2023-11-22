import java.util.ArrayList;
import java.util.List;

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

    // public Matrice multiplicationParrallele(Matrice m) {
    //     Matrice resultat = new Matrice(taille);
    //     MatriceThread[] threads = new MatriceThread[taille];

    //     for (int i = 0; i < taille; i++) {
    //         threads[i] = new MatriceThread(this, m, resultat, i);
    //         threads[i].start();
    //     }
    //     for(MatriceThread matT : threads){
    //         try{
    //             matT.join();
    //         }
    //         catch(Exception e){
    //             System.out.println(e.getMessage());
    //         }
    //     }
    //     return resultat;
    // }

    public Matrice multiplicationParCoeur(Matrice matrice){
        int n = matrice.taille;
        Matrice res = new Matrice(n);
        List<MatriceThread> listThread = new ArrayList<>();
        int nbThread = Runtime.getRuntime().availableProcessors();
        int nbLignesParThread = n/nbThread;

        int debut,fin = 0;
        for(int i = 0; i<nbThread; i++){
            debut = i*nbLignesParThread;
            fin = (i+1)*nbLignesParThread;
            if(i==nbThread-1){
                fin = n;
            MatriceThread matThr = new MatriceThread(this, matrice, res, debut, fin);
            listThread.add(matThr);
            matThr.start();
            }
        }
        for(MatriceThread matT : listThread){
            try{
                matT.join();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return res;
    }

}