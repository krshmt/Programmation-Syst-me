import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main{
    public static void main(String[] args) {
        final int SIZE = 100000;
        final int MAX = 10;
        Random random = new Random();

        int[] numbers = {1,2,4,5,6,7,98,445,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0};

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



    }
}