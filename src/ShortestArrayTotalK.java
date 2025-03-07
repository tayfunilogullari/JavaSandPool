import java.io.IOException;

public class ShortestArrayTotalK {

    public int shortestSubarray(int[] nums, int k) {

        /*int e = checkAll(nums, k);
        if (e <= 0) {
            int res = runBinaryWindow(nums, k);
            return res > nums.length ? -1 : res;
        }
        else {
            return e;
        }*/

        for (int dif = 1; dif < nums.length; dif++) {
            int st = 0;
            int end = dif;
            int total = dif;
            while (end <= nums.length) {

            }
        }

        int[] prefix = prefixTotal(nums);

        int res = compareTotals(nums, prefix, k);
        return res;
    }

    private int compareTotals(int[] nums, int[] prefix, int k) {
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;

        while (r < prefix.length) {
            if (prefix[r] >= k) {
                min = Math.min(r+1,min);
                break;
            }
            r++;
        }
        r = 1;
        int negCount = 0;


        while (r < prefix.length) {
            if (prefix[r] < prefix[l]) {
                l = r;
                r++;
            }
            else if (prefix[r] - prefix[l] >= k) {
                min = Math.min(r-l,min);
                l++;
            }
            else {
                r++;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int[] prefixTotal(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i-1];
        }
        return prefix;
    }

    private int runBinaryWindow(int[] nums, int k) {

        int l = 1;
        int r = nums.length;
        int min = Integer.MAX_VALUE;

        while (l <= r) {
            int m = l + (r-l)/2;
            if (runByLength(nums, k, m)) {
                min = Math.min(min,m);
                r = m-1;
            }
            else {
                l = m+1;
            }
        }
        return l;
    }

    private boolean runByLength(int[] nums, int k, int m) {

        int total = 0;
        for (int i = 0; i < m; i++) {
            total += nums[i];
        }

        if (total >= k) {
            return true;
        }

        int start = 0;
        int end = m;
        while (end < nums.length) {
            total -= nums[start];
            total += nums[end];
            if (total >= k) {
                return true;
            }
            start++;
            end++;
        }
        return false;
    }

    private int checkAll(int[] nums, int k) {

        int total = 0;
        for (int i : nums) {
            if (i >= k) {
                return 1;
            }
            total += i;
            if (total >= k) {
                return 0;
            }
        }
        return -1;
    }




    public static void main(String[] args) throws IOException {

        ShortestArrayTotalK sen = new ShortestArrayTotalK();
        int r = sen.shortestSubarray(new int[]{-34,37,51,3,-12,-50,51,100,-47,99,34,14,-13,89,31,-14,-44,23,-38,6}, 151);
        System.out.println(r);
        //r = sen.minLength("ACBBD");
        //System.out.println(r);
    }
}
