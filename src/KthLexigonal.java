import java.io.IOException;

public class KthLexigonal {

    Integer remain=0;
    public String getHappyString(int n, int k) {
        remain = k;
        int len = 3;
        int[] arr = new int[n];
        arr[0] = len;
        for (int i = 1; i < n; i++) {
            arr[i] = 2;
            len*=2;
        }
        if (len < k) {
            return "";
        }

        char[] res = new char [n];

        res[0] = findFirst(len);

        len/=3;
        int index = 1;
        while (len > 1) {
            res[index] = findOthers(res[index-1], len);
            index++;
            len /= 2;
        }

        return new String(res);
    }

    private char findOthers(char pre, int len) {

        len /= 2;

        int val = this.remain;
        val--;

        if (val > 0) {
            val /= len;
        }
        else
            val = 0;

        this.remain %= len;

        return selectChar(pre, val);
    }

    private char findFirst(int len) {
        len /= 3;
        int val = this.remain;
        val--;
        if (val > 0) {
            val /= len;
        }
        else
            val = 0;

        this.remain %= len;

        switch (val) {
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
        }

        return 'z';
    }


    private char selectChar(char pre, int select) {
        if (select == 0) {
            if (pre == 'a') {
                return 'b';
            }
            return 'a';
        }
        else if (pre == 'c') {
            return 'b';
        }
        return 'c';
    }

    public static void main(String[] args) throws IOException {

        KthLexigonal sen = new KthLexigonal();

        String r = sen.getHappyString(10,100);

        System.out.println(r);
    }
}
