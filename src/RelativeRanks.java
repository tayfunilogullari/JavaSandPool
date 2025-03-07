import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int s : score) {
            maxHeap.add(s);
        }
        int counter = 1;
        while (!maxHeap.isEmpty()) {
            Integer s = maxHeap.remove();
            for (int i = 0; i < score.length; i++) {
                if (score[i] == s) {
                    result[i] = getRankName(counter);
                    counter++;
                }
            }
        }
        return result;
    }

    private String getRankName (int rank) {
        switch (rank) {
            case 1:
                return "Gold Medal";

            case 2:
                return "Silver Medal";
            case 3:
                return "Bronze Medal";
            default:
                return String.valueOf(rank);
        }
    }


    public static void main(String[] args) throws IOException {

        RelativeRanks sen = new RelativeRanks();
        String[] r = sen.findRelativeRanks(new int[]{5,4,3,2,1});
        System.out.println(Arrays.toString(r));
        //r = sen.minLength("ACBBD");
        //System.out.println(r);
    }

}
