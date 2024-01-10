import java.util.List;

public class T implements Runnable{
    private int[] list;
    private int start;
    private int end;
    private Main main;

    public T(int[] list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
        this.main = new Main(Integer.MIN_VALUE);
    }

    @Override
    public void run() {
        int max = Integer.MIN_VALUE;
        if (end - start < 10) {
            for (int i = start; i < end; i++) {
                if (list[i] > max) {
                    max = list[i];
                }
            }
        } 
        else {
            int mid = start + (end - start) / 2;
            T left = new T(list, start, mid);
            T right = new T(list, mid, end);
            left.run();
            right.run();
        }
        if(max > main.getValeurMax()){
            main.setValeurMax(max);
        }
    }
}
