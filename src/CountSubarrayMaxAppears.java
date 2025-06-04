import java.io.IOException;

public class CountSubarrayMaxAppears {


    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max,num);
        }

        long res = 0;


        int n = nums.length;

        for (int left = 0; left < n; left++) {
            int right = left;
            int maxCount = 0;
            while (right < n && maxCount < k) {
                if (nums[right] == max) {
                    maxCount++;
                }
                right++;
            }
            if (maxCount < k) {
                break;
            }

            res += n - right + 1;


        }

        return res;
    }

    /*private void change(Double val) {

        val += 2;
        val.
        System.out.println(val);
    }
    private void call() {
        Double val = 5.5;
        change(val);
        System.out.println(val);
    }*/

    public static void main(String[] args) throws IOException {
        CountSubarrayMaxAppears cc = new CountSubarrayMaxAppears();

        long res = cc.countSubarrays(new int[] {1,3,2,3,3}, 2);
        System.out.println(res);
    }

}
