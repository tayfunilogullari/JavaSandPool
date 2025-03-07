import java.io.IOException;

public class BestSightseeingPair {


    public int maxScoreSightseeingPair(int[] values) {

        int max = 0;
        int preVal = values[0];

        for (int i = 1; i < values.length; i++) {
            preVal--;
            max = Math.max(max, preVal + values[i]);
            if (values[i] > preVal) {
                preVal = values[i];
            }
        }
        return max;

        /*for (int i = 0; i < values.length; i++){

        }*/




        /*int[][] forward = new int[values.length][2];

        int max = 0;
        for (int i = 0; i < values.length - 1; i++) {
            max--;
            if (max < values[i]) {
                max = values[i];
                forward[i][1] = i;
            } else {
                forward[i][1] = forward[i - 1][1];
            }
            forward[i][0] = max;
        }
        forward[values.length - 1][0] = max - 1;
        forward[values.length - 1][1] = values.length - 2;

        max = 0;
        int[][] backward = new int[values.length][2];
        for (int i = values.length - 1; i > 0; i--) {
            max--;
            if (max < values[i]) {
                max = values[i];
                backward[i][1] = i;
            }
            else {
                backward[i][1] = backward[i+1][1];
            }
            backward[i][0] = max;
        }
        backward[0][0] = max - 1;
        backward[0][1] = 1;

        max = 0;
        for (int i = 0; i < forward.length; i++) {
            if (forward[i][1] != backward[i][1]) {
                max = Math.max(max, forward[i][0] + backward[i][0]);
            }
        }
        return max;*/
    }


    public static void main(String[] args) throws IOException {

        BestSightseeingPair sen = new BestSightseeingPair();
        double r = sen.maxScoreSightseeingPair(new int[]{4,6,3,2,6,3,9,9,3});
        System.out.println(r);
        //r = sen.minLength("ACBBD");
        //System.out.println(r);
    }
}
