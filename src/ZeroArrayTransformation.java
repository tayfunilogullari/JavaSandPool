import java.io.IOException;

public class ZeroArrayTransformation {


    public boolean isZeroArray(int[] nums, int[][] queries) {

        int[] freq = new int[nums.length + 1];

        for (int[] arr : queries) {
            freq[arr[0]]++;

            freq[arr[1] + 1]--;
        }

        int val = 0;
        for (int i = 0; i < freq.length; i++) {
            val += freq[i];
            if (val < nums[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        ZeroArrayTransformation zz = new ZeroArrayTransformation();

        boolean res = zz.isZeroArray(new int[]{4,3,2,1}, new int[][]{{1,3},{0,2}});
        System.out.println(res);
    }
}
