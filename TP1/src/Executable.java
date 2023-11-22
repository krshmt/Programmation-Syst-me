public class Executable{
public static void main(String[]args) {
        int taille = Integer.parseInt(args[0]);
        Matrice matrice1 = new Matrice(taille);
        Matrice matrice2 = new Matrice(taille);

        Matrice resultat = new Matrice(taille);

        matrice1.init();
        matrice2.init();

        long startTime = System.currentTimeMillis();
        resultat = matrice1.multiplier(matrice2);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Temps d'exécution en séquentielle : " + executionTime + " millisecondes");

        Matrice resultat2 = new Matrice(taille);
        long startTime2 = System.currentTimeMillis();
        resultat2 = matrice1.multiplicationParrallele(matrice2);
        long endTime2 = System.currentTimeMillis();

        System.out.println("");
        long executionTime2 = endTime2 - startTime2;
        System.out.println("Temps d'exécution pour le parallèle: " + executionTime2 + " millisecondes");
}
}