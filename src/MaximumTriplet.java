import java.io.IOException;

public class MaximumTriplet {

    public long maximumTripletValue(int[] nums) {
        long res = 0;

        int r = nums.length - 1;
        int l = r - 1;
        int m = r - 2;


        return res;
    }

    public static void main(String[] args) throws IOException {

        MaximumTriplet mt = new MaximumTriplet();
        long res = mt.maximumTripletValue(new int[]{12,6,1,2,7});
        System.out.println(res);

    }
}
