import java.util.*;

class GFG
{

    static int num;

    /* we have 2 choices for each of the n bits either we
    can include i.e invert the bit or we can exclude the
    bit i.e we can leave the number as it is. */
    static void grayCodeUtil(Vector<Integer> res, int n)
    {
        // base case when we run out bits to process
        // we simply include it in gray code sequence.
        if (n == 0)
        {
            res.add(num);
            return;
        }

        // ignore the bit.
        grayCodeUtil(res, n - 1);

        // invert the bit.
        num = num ^ (1 << (n - 1));
        grayCodeUtil(res, n - 1);
    }

    // returns the vector containing the gray
// code sequence of n bits.
    static Vector<Integer> grayCodes(int n)
    {
        Vector<Integer> res = new Vector<Integer>();

        // num is passed by reference to keep
        // track of current code.
        num = 0;
        grayCodeUtil(res, n);

        return res;
    }

    // Driver function.
    public static void main(String[] args)
    {
        int n = 3;
        /*Vector<Integer> code = grayCodes(n);
        for (int i = 0; i < code.size(); i++)
            System.out.print(code.get(i) +"\n");
            */

        System.out.println("-3%10 : " + -3%10);
        System.out.println("3%10 : " + 3%10);
        System.out.println("-7%10 : " + -7%10);
        System.out.println("7%10 : " + 7%10);
        System.out.println("-13%10 : " + -13%10);


    }
}
