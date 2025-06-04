import java.io.IOException;

public class HouseRobber {

    public int minCapability(int[] nums, int k) {

        int[][] dp = new int[nums.length][k];

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = i;

            while (index < nums.length) {

            }
        }

        return res;
    }


    public static void main(String[] args) throws IOException {

        HouseRobber sum = new HouseRobber();
        int r = sum.minCapability(new int[]{2,3,5,9}, 2);
        System.out.println(r);

    }
}
