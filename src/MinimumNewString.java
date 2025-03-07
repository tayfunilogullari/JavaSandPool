import java.io.IOException;
import java.util.Stack;

public class MinimumNewString {
    final static char A = 'A';
    final static char B = 'B';
    final static char C = 'C';
    final static char D = 'D';
    public int minLength(String s) {
        char[] arr = new char[s.length()];
        int lastIndex = -1;
        for (char c : s.toCharArray()) {
            if (lastIndex != -1 && (c == B && arr[lastIndex] == A || c == D && arr[lastIndex] == C)) {
                lastIndex--;
            }
            else {
                lastIndex++;
                arr[lastIndex] = c;
            }
        }
        return lastIndex+1;
    }
/*
    final static String AB = "AB";
    final static String CD = "CD";
    public int minLength(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == 'B' && stack.peek() == 'A' || c == 'D' && stack.peek() == 'C') {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        return stack.size();

       char[] arr = s.toCharArray();

        while (true)
        {
            int len = arr.length;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] == 'A' && arr[i+1] == 'B')
                {

                }
            }

        }
*/

        /*
        Stack<Character> stack = new Stack<>();
        Stack<Character> reverseStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            reverseStack.push(s.charAt(i));
        }

        char bOrD = '\s';
        char aOrC = '\s';

        while (true) {
            int size = reverseStack.size();
            while (!reverseStack.isEmpty()) {
                if ((bOrD == 'B' && aOrC == 'A') || (bOrD == 'D' && aOrC == 'C')) {
                    aOrC = '\s';
                    bOrD = '\s';
                }
                else {
                    if (bOrD != '\s') {
                        stack.push(bOrD);
                    }
                    bOrD = aOrC;
                    aOrC = reverseStack.pop();
                }
            }
            if ((bOrD == 'B' && aOrC == 'A') || (bOrD == 'D' && aOrC == 'C')) {
                aOrC = '\s';
                bOrD = '\s';
            }
            else {
                if (bOrD != '\s') {
                    stack.push(bOrD);
                    bOrD = '\s';
                }
                if (aOrC != '\s') {
                    stack.push(aOrC);
                    aOrC = '\s';
                }
            }
            while (!stack.isEmpty()) {
                reverseStack.push(stack.pop());
            }
            if (size == reverseStack.size()) {
                break;
            }
        }

        return reverseStack.size();*/


  /*      Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        while (true)
        {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != '\s') {
                    stack.push(arr[i]);
                    arr[i] = '\s';
                }
                else {
                    break;
                }
            }


            char bOrD;
            if (!stack.isEmpty()){
                bOrD = stack.pop();
            }
            else {
                return 0;
            }

            char aOrC;
            if (!stack.isEmpty()){
                aOrC = stack.pop();
            }
            else {
                return 1;
            }

            while (!stack.isEmpty()) {
                if (aOrC == )
            }

        }
*/
       /* StringBuilder builder = new StringBuilder(s);
        int exLength = s.length();
        while (true) {
            int index = builder.indexOf(AB);
            if (index != -1) {
                builder.delete(index, index+2);
            }
            index = builder.indexOf(CD);
            if (index != -1) {
                builder.delete(index, index+2);
            }
            if (builder.length() == exLength) {
                break;
            }
            else {
                exLength = builder.length();
            }
        }
        return exLength;*/
    //}

    public static void main(String[] args) throws IOException {

        MinimumNewString sen = new MinimumNewString();
        int r = sen.minLength("ABFCACDB");
        System.out.println(r);
        r = sen.minLength("ACBBD");
        System.out.println(r);
    }
}
