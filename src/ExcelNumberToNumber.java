import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ExcelNumberToNumber {


    public int titleToNumber(String columnTitle) {

        AtomicInteger rrr = new AtomicInteger(columnTitle.length() - 1);// new AtomicInteger();
        int rr = columnTitle.codePoints().map(c ->
             ((c - 'A') + 1) * (int) Math.pow(26, rrr.getAndDecrement())
        ).sum();
        //.mapToInt(c -> (int)c).sum();
        System.out.println(rr);


        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++)
        {
            result *= 26;
            result += columnTitle.charAt(i) - 'A';
            result++;
        }
        return result;
    }


    public static void main(String[] args) throws IOException {

        ExcelNumberToNumber sum = new ExcelNumberToNumber();
        int r = sum.titleToNumber("AAY");
        System.out.println(r);

    }
}
