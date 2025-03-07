import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxAverageRatio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int len = classes.length;
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingDouble(a -> ((double) a[0] / a[1]) - ((double) (a[0] + 1) / (a[1] + 1))));

        //(a[1]*b[1]*(a[1] - b[1])) - (b[1]*a[0]*(b[1] + 1)) + (a[1]*b[0]*(a[1] + 1))

        for (int[] arr : classes) {
            que.add(arr);
        }

        for (; extraStudents > 0; extraStudents--) {
            int[] arr = que.poll();
            ++arr[0];
            ++arr[1];
            que.add(arr);
        }

        double res = 0.0d;

        while (!que.isEmpty()) {
            int[] arr = que.poll();
            double v1 = arr[0];
            double v2 = arr[1];
            v1 /= v2;
            v1 /= len;
            res = Double.sum(res, v1);
        }

        return res;
    }


    public static void main(String[] args) throws IOException {

        MaxAverageRatio sen = new MaxAverageRatio();
        double r = sen.maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}}, 2);
        System.out.println(r);
        //r = sen.minLength("ACBBD");
        //System.out.println(r);
    }
}
