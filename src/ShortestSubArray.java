import java.io.IOException;
import java.util.Arrays;

public class ShortestSubArray {

    public int minimumSubarrayLength(int[] nums, int k) {
        if (k == 0) {
            return 1;
        }

        int minL = Integer.MAX_VALUE;

        int[] bits = new int[32];
        int l = 0;
        int r = 0;

        int val = 0;

        while (r < nums.length && l < nums.length) {
            if (val < k) {
                addArr(bits, nums[r]);
                r++;
                val = bitsToNum(bits);
            }

            if (val >= k) {
                minL = Math.min(minL, r-l);
                subtArr(bits, nums[l]);
                l++;
                val = bitsToNum(bits);
            }
        }
        return minL < Integer.MAX_VALUE ? minL : -1;

    }
    private void addArr(int[] target, int[] add) {
        for (int i = 0; i < 32; i++) {
            target[i] += add[i];
        }
    }
    private void addArr(int[] target, int add) {
        for (int i = 0; i < 32 && add > 0; i++) {
            target[i] += (add&1);
            add >>=1;
        }
    }

    private void subtArr(int[] target, int[] add) {
        for (int i = 0; i < 32; i++) {
            target[i] -= add[i];
        }
    }

    private void subtArr(int[] target, int s) {
        for (int i = 0; i < 32 && s > 0; i++) {
            target[i] -= (s&1);
            s >>= 1;
        }
    }

    private int bitsToNum(int[] arr){
        int num=0;
        for (int i = 31; i >= 0; i--) {
            num <<=1;
            if (arr[i] > 0) {
                num++;
            }
        }
        return num;
    }

    private int[] numToBits(int num) {
        int[] arr = new int[32];
        int i = 0;
        while (num>0) {
            arr[i] += (num&1);
            num >>= 1;
            i++;
        }
        return arr;
    }



    private int toOr(int[] nums, int start, int end){
        int ans = 0;
        for (; start< end; start++) {
            ans |= nums[start];
        }
        return ans;
    }

    private boolean[][] convertToMatrix (int[] nums) {
        boolean[][] bitMatrix = new boolean[nums.length][32];
        for (int i = 0; i < bitMatrix.length; i++) {
            int val = nums[i];
            int j = 0;
            while (val > 0) {
                bitMatrix[i][j] = (val&1) > 0;
                val >>=1;
                j++;
            }
        }
        return bitMatrix;
    }



    public static void main(String[] args) throws IOException {

        ShortestSubArray sen = new ShortestSubArray();
        int r = sen.minimumSubarrayLength(new int[]{1,2,32,21}, 55);
        System.out.println(r);
        //r = sen.minLength("ACBBD");
        //System.out.println(r);
    }
}
