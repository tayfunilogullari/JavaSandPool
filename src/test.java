import java.io.IOException;
import java.math.BigDecimal;

public class test {

    private int fonk (BigDecimal bakiye) {


        /*int count = 0;
        BigDecimal waste = new BigDecimal(0.1);
        while (bakiye.compareTo() > 0.0) {
            bakiye.subtract(waste);
            System.out.println("bakiye " + bakiye);
            count++;
            //waste += 0.1;
        }
        System.out.println("bakiye " + bakiye);
        System.out.println("count " + count);
        System.out.println("waste " + waste);
        return count;

         */
        return 0;
    }


    public static void main(String[] args) throws IOException {
        test cc = new test();

        int res = cc.fonk(new BigDecimal(1.0));
        System.out.println(res);
    }

}
