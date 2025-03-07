import java.io.IOException;

public class LockedParanthesis {

    public boolean canBeValid(String s, String locked) {

        if((s.length() & 1) == 1) return false;
        int cmin = 0, cmax = 0;
        for(int i = 0; i < s.length(); i++) {
            if(locked.charAt(i) == '0') {
                cmin--;
                cmax++;
            }
            else {
                if(s.charAt(i) == '(') {
                    cmax++;
                    cmin++;
                }
                else {
                    cmax--;
                    cmin--;
                }
            }
            if(cmax < 0) return false;
            cmin = Math.max(cmin, 0);
        }
        return cmin == 0;



/*
        if (s.length()%2 == 1) {
            return false;
        }
        int freeCount = 0;
        int openCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                freeCount++;
            }
            else if (s.charAt(i) == '(') {
                openCount++;

            }
            else if (openCount > 0) {
                openCount--;
            }
            else if (freeCount > 0) {
                freeCount--;
            }
            else {
                return false;
            }
        }

        if (freeCount < openCount) {
            return false;
        }

        freeCount = 0;
        int closeCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                freeCount++;
            }
            else if (s.charAt(i) == ')') {
                closeCount++;
            }
            else if (closeCount > 0) {
                closeCount--;
            }
            else if (freeCount > 0) {
                freeCount--;
            }
            else {
                return false;
            }
        }

        return true;*/
    }


    public static void main(String[] args) throws IOException {

        LockedParanthesis sen = new LockedParanthesis();
        boolean r = sen.canBeValid(
                new String("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))("),
                new String("100011110110011011010111100111011101111110000101001101001111"));
        System.out.println(r);
        //r = sen.minLength("ACBBD");
        //System.out.println(r);
    }
}
