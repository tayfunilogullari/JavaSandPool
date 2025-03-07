import java.io.IOException;
import java.util.Arrays;

public class QuickSort {

    public int[] sort(int[] arr) {
        int[] sorted = new int[arr.length];



        return sorted;
    }

    public static void main(String[] args) throws IOException {

        QuickSort sen = new QuickSort();
        int[] r = sen.sort(new int[]{5,1,5,5,1,3,4,5,1,4});
        System.out.println(Arrays.toString(r));
        //r = sen.minLength("ACBBD");
        //System.out.println(r);
    }
}
