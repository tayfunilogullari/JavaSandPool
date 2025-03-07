import java.util.*;

public class IndexOnLexiconal {

    Integer overallCounter = 0;
    public int findKthNumber(int n, int k) {
        int currentVal = 0 ;
        if (n < 10)
        {
            return k;
        }
        if (n-k < k)
        {
            runReverseWithComplement(n,n - k +1);
            return this.resultNumber;
            //currentVal =fullGoonCountReverse(0, n,n - k +1);
        }
        else
            currentVal = fullGoonCount(0, n, k);

        return currentVal;
    }

    private void runReverseWithComplement(final int n, final int k)
    {
        int last = findLast(n);
        last *= 10;
        last += 9;

        int diff = last - n;

        final int number = k + diff;

        while (resultNumber == 0)
        {
            findNumberWithComplement(last, number);
            if (resultNumber != 0)
                break;

            last = rescaleNumber(last, number);
            if (last == -2)
                break;
        }
    }

    private int rescaleNumber(int last, final int wantedIndex)
    {
        last /=10;
        this.overallCounter++;

        synchronized (System.out) {
            System.out.printf("Order: %s  -  Val : %s", overallCounter ,last);
            System.out.println();
        }

        if (this.overallCounter == wantedIndex)
        {
            this.resultNumber = last;
            return -2;
        }

        if (last %10 == 0) {
            last = rescaleNumber(last, wantedIndex);
            if (last == -2)
                return -2;
        }
        else
            last--;

        last *=10;
        last += 9;

        return last;
    }

    int resultNumber = 0;
    private void findNumberWithComplement(int last, final int wantedIndex)
    {
        this.overallCounter++;
        if (this.overallCounter == wantedIndex)
        {
            resultNumber = last;
            return;
        }

        for (int index = 9; index > 0; index--)
        {
            last--;
            this.overallCounter++;
            synchronized (System.out) {
                System.out.printf("Order: %s  -  Val : %s", overallCounter ,last);
                System.out.println();
            }
            if (this.overallCounter == wantedIndex)
            {
                resultNumber = last;
                return;
            }
        }
    }

    private int runReverse(final int n, final int k)
    {
        int lastOne = findLast(n);


        int value = ascendingCount(lastOne, k, n);
        if (value > 0)
            return value;

        lastOne -= 9;

        value = divideByTen(lastOne, k);
        if (value > 0)
            return value;

        return -1;
    }

    private int divideByTen(int value, int k)
    {
        if (value/10 > 0)
        {
            value /= 10;
            overallCounter++;
            if (overallCounter == k)
                return value;
        }
        return value;
    }


    private int checkLimit(int value, int n)
    {
        if (value*10 > n)
            return -1;

        value *= 10;

        if (value + 9 > n)
            return n;

        return value + 9;
    }

    private int ascendingCount(int value, final int k, final int n)
    {
        for (int i = value %10; i >= 0; i--)
        {
            value--;
            int val = checkLimit(value,n);
            if (val > -1)
                ascendingCount(val, k, n);

            overallCounter++;

            if (overallCounter == k)
                return value;
        }
        return -1;
    }



    private int findLast (final int n)
    {
        if (n / 10 > 0)
            return 10*findLast(n / 10) + 9;
        return 0;
    }


    private int fulReverseCall(final int n, final int k)
    {
        for (int i = 9 ; i >= 1 ; i--)
        {
            int result = fullGoonCountReverse2(i, n, k);
            if (result > 0)
                return result;

            overallCounter++;
            if (overallCounter == k)
                return i;
        }
        return -3;
    }

    private int fullGoonCountReverse2(int currentVal, final int n, final int k)
    {
        currentVal *= 10;
        if (currentVal > n)
            return -1;
        else
        {
            currentVal += 9;
            int result;
            if (currentVal > n)
            {
                currentVal = n;
            }
            else
            {
                result = fullGoonCountReverse2(currentVal, n, k);
                if (result > 0)
                    return result;
            }

            overallCounter++;
            if (overallCounter == k)
                return currentVal;

            synchronized (System.out) {
                System.out.printf("Order: %s  -  Val : %s", n - overallCounter +1 ,currentVal );
                System.out.println();
            }

            result = decreaseValues(currentVal, n, k);
            if (result > 0)
                return result;
        }
        return -2;
    }

    private int decreaseValues(int currentVal, final int n, final int k)
    {
        for (int index = currentVal%10 ; index > 0; index-- )
        {
            currentVal--;
            overallCounter++;
            if (overallCounter == k)
                return currentVal;
        }
        return  -1;
    }

    static final int maxVal =  Integer.MAX_VALUE / 10;
    private int fullGoonCount(int currentVal, final int n, final int k)
    {
        if (currentVal > maxVal) {
            return -1;
        }
        else {
            currentVal = currentVal * 10;
            if (currentVal > n)
                return -1;
        }
        int result = 0;
        if (currentVal != 0)
        {
            this.overallCounter++;
            if (this.overallCounter == k)
                return currentVal;

            result = fullGoonCount(currentVal, n, k);
            if (result != -1)
                return result;
        }

        for (int index = 1; index <= 9; index++)
        {
            currentVal++;
            if (currentVal > n)
                return -1;

            this.overallCounter++;
            if (this.overallCounter == k)
                return currentVal;
            else
            {
                result = fullGoonCount(currentVal, n, k);
                if (result != -1)
                    return result;
            }
        }

        return -1;
    }


    private int fullGoonCountReverse(int currentVal, final int n, final int k)
    {
        currentVal *= 10;
        currentVal += 9;
        if (currentVal > n)
            return -1;
        else
        {
            int result = fullGoonCountReverse(currentVal, n, k);
            if (result != -1)
                return result;

            overallCounter++;
            synchronized (System.out) {
                System.out.printf("Order: %s  -  Val : %s", n - overallCounter +1 ,currentVal );
                System.out.println();
            }

            if (overallCounter == k)
                return currentVal;
        }


        for (int index = 9; index > 0; index-- )
        {
            currentVal--;
            int result = fullGoonCountReverse(currentVal, n, k);
            if (result != -1)
                return result;

            overallCounter++;
            if (overallCounter == k)
                return currentVal;

        }
        return  -1;
    }

    private int goOnCount(int currentVal, final int n, final int k)
    {
        if (currentVal > Integer.MAX_VALUE / 10){
            return -1;
        }
        else {
            currentVal = currentVal * 10;
            if (currentVal > n)
                return -1;
        }

        this.overallCounter++;
        if (this.overallCounter == k)
            return currentVal;

        int result = goOnCount(currentVal, n, k);
        if (result != -1)
            return result;

        for (int index = 1; index <= 9; index++)
        {
            currentVal++;
            if (currentVal > n)
                return -1;

            this.overallCounter++;
            if (this.overallCounter == k)
                return currentVal;
            else
            {
                result = goOnCount(currentVal, n, k);
                if (result != -1)
                    return result;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        //IndexOnLexiconal lexico = new IndexOnLexiconal();

        //int result = lexico.findKthNumber(100,90);
        //System.out.println("Result: " +result);

        for (int i = 0; i < (1 << 4); i++)
        {

            // Generating the decimal
            // values of gray code then using
            // bitset to convert them to binary form
            int m = i >> 1;
            int val = (i ^ m);

            // Converting to binary string
            String s = Integer.toBinaryString(val);
            System.out.print(
                    String.format("%1$" + 4 + "s", s)
                            .replace(' ', '0')
                            + " ");
        }

    }

}
