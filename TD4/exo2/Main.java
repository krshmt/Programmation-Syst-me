import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main{

    private static int valeurMax;

    public Main(int valeurMax){
        this.valeurMax = valeurMax;
    }

    public int getValeurMax(){
        return this.valeurMax;
    }

    public void setValeurMax(int valeurMax){
        this.valeurMax = valeurMax;
    }

    public static void main(String[] args) {
        final int SIZE = 100000;
        final int MAX = 10;
        Random random = new Random();

        int[] numbers = {1,2,4,5,6,7, 8, 9, 10, 11,44, 12, 13, 14, 15, 16, 17,18,19,20,21,22,23,24,25,26,27,28,29,30};

        ForkJoinPool pool = new ForkJoinPool();
        MaximumFinder finder = new MaximumFinder(numbers, 0, numbers.length);
        System.out.println("Le maximum est " + pool.invoke(finder));

        int[] array = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(MAX);
        }
        array[random.nextInt(SIZE)] = MAX + 1;
        finder = new MaximumFinder(array, 0, array.length);
        System.out.println("Le maximum est " + pool.invoke(finder));


        T t = new T(numbers, 0, numbers.length);
        t.run();
        System.out.println("La valeur maximum dans la liste est : " +  valeurMax);
    }
}