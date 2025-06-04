import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class CountWorkDay {


    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int prevEnd = 0;
        int dayOff = 0;
        for (int[] arr : meetings) {
            if (prevEnd > arr[0]){
                if(prevEnd < arr[1]) {
                    dayOff += arr[1] - prevEnd;
                    prevEnd = arr[1];
                }
            }
            else {
                dayOff += arr[1] - arr[0] + 1;
                prevEnd = arr[1];
            }
        }
        return days - dayOff;
    }



    public static void main(String[] args) throws IOException {

        CountWorkDay cc = new CountWorkDay();
        int res = cc.countDays(10, new int[][]{{5,7},{1,3},{9,10}});
        System.out.println(res);

    }
}
