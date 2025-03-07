import java.io.IOException;

public class MinimizeXOR {

    public int minimizeXor(int num1, int num2) {

        boolean[] bits = new boolean[32];

        int res = num1;
        int countOf1 = 0;
        int countOf2 = 0;

        int index = 0;
        while (num1 > 0) {
            if((num1&1) == 1) {
                countOf1++;
                bits[index] = true;
            }
            if (num2 > 0){
                if ((num2&1) == 1) {
                    countOf2++;
                }
                num2 >>= 1;
            }
            num1 >>= 1;
            index++;
        }

        while (num2 > 0) {
            if ((num2&1) == 1) {
                countOf2++;
            }
            num2 >>= 1;
        }

        int dif = countOf2 - countOf1;

        if (dif < 0) {
            int powerOfTwo = 1;
            for (int i = 0; i < bits.length && dif < 0; i++) {
                if (bits[i]) {
                    res -= powerOfTwo;
                    dif++;
                }
                powerOfTwo <<= 1;
            }
        }
        else {
            int powerOfTwo = 1;
            for (int i = 0; i < bits.length && dif > 0; i++) {
                if (!bits[i]) {
                    res += powerOfTwo;
                    dif--;
                }
                powerOfTwo <<= 1;
            }
        }

        return res;
    }




    public static void main(String[] args) throws IOException {

        MinimizeXOR sen = new MinimizeXOR();
        int r = sen.minimizeXor(79,74);
        System.out.println(r);
        //r = sen.minLength("ACBBD");
        //System.out.println(r);
    }
}
