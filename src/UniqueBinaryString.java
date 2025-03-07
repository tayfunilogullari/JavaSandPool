import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {
        int len = nums.length;

        List<Integer> list = new ArrayList<>();
        for (String s : nums) {
            list.add(numValue(s, len));
        }

        int res = 0;
        while (list.contains(res)) {
            res++;
        }
        return numToBinStr(res, len);
    }

    private String numToBinStr(int val, int len) {
        StringBuilder res = new StringBuilder();
        int most = powOfTwo(len);

        while (len > 0) {
            if (val >= most) {
                res.append('1');
                val -= most;
            }
            else {
                res.append('0');
            }
            most /= 2;
            len--;
        }

        return res.toString();
    }

    private int numValue(String s, int len) {
        int most = powOfTwo(len);
        int val = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                val += most;
            }
            most /= 2;
        }
        return val;
    }

    private int powOfTwo(int len) {
        if (len > 1) {
            return powOfTwo(len - 1)*2;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {

        UniqueBinaryString sen = new UniqueBinaryString();

        String r = sen.findDifferentBinaryString(new String[]{"00","01"});

        System.out.println(r);
    }
}
