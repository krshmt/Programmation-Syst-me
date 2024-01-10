import java.util.concurrent.RecursiveTask;

public class MaximumFinder extends RecursiveTask<Integer> {
    private int[] list;
    private int start;
    private int end;

    public MaximumFinder(int[] list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start < 10) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i < end; i++) {
                if (list[i] > max) {
                    max = list[i];
                }
            }
            return max;
        } else {
            int mid = start + (end - start) / 2;
            MaximumFinder left = new MaximumFinder(list, start, mid);
            MaximumFinder right = new MaximumFinder(list, mid, end);
            left.fork();
            return Math.max(left.join(), right.compute());
        }
    }
    
}
