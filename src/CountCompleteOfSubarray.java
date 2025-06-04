import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountCompleteOfSubarray {

    public int countCompleteSubarrays(int[] nums) {
        int res = 1;
        int[] freq = new int[2001];
        Map<Integer,Integer> map = new HashMap<>();



        for (int num : nums) {
            freq[num]++;
            if (freq[num] == 1) {
                res = 1;
            }
            else {
                res++;
            }
        }

        int firstPart = 0;
        for (int num : nums) {
            freq[num]--;
            if (freq[num] == 0) {
                break;
            }
            else {
                firstPart++;
            }
        }

        return res*(res+1)/2;
    }

    public static void main(String[] args) throws IOException {
        CountCompleteOfSubarray cc = new CountCompleteOfSubarray();
        int val = cc.countCompleteSubarrays(new int[]{1,3,1,2,2});

        System.out.println(val);
    }
}
