import java.io.IOException;

public class FindLargestLexi {

    public String answerString(String word, int numFriends) {

        int len = (word.length() - numFriends) +1;

        int first = 0;
        int last = 0;

        int val = 0;

        int firstMultiplier = findMultiply(len);

        while (last < len) {
            val *= 26;
            val += (int)(word.charAt(last) - 'a');
            last++;
        }

        String res = word.substring(first, last);

        int largest = val;

        for (; last < word.length(); last++, first++) {
            int firstVal = (word.charAt(first) - 'a');
            firstVal *= firstMultiplier;
            val -= firstVal;
            val *= 26;

            val += (int)(word.charAt(last) - 'a');

            if (largest < val) {
                res = word.substring(first, last);
            }
        }

        return res;

    }

    int findMultiply(int len) {
        int res = 1;
        for (; len > 1; len--) {
            res *= 26;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        FindLargestLexi l  = new FindLargestLexi();
        String res = l.answerString("bif",2);
        System.out.println(res);
    }
}
