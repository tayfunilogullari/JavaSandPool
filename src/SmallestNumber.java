import java.io.IOException;

public class SmallestNumber {

    char[] arr;
    char[] rules;
    public String smallestNumber(String pattern) {
        rules = pattern.toCharArray();
        int size = pattern.length() +1;
        arr = new char[size];
        char init = '1';
        arr[0] = init;
        for (int i = 1; i < size; i++) {
            char currentChar = (char) (init + i);
            insertChar(currentChar, i);
        }

        return new String(arr);
    }

    private void insertChar(char in, int index) {
        arr[index] = in;
        while (index > 0 && !readRule(arr[index-1], in, index-1)) {
            swap(index-1, index);
            index--;
        }
    }

    private boolean readRule(char ch1, char ch2, int rule) {
        if (ch1 < ch2) {
            return rules[rule] == 'I';
        }
        return rules[rule] == 'D';
    }

    private void swap(int i, int y) {
        char c = arr[i];
        arr[i] = arr[y];
        arr[y] = c;
    }



    public static void main(String[] args) throws IOException {

        SmallestNumber sen = new SmallestNumber();

        String r = sen.smallestNumber("DDD");
        System.out.println(r);
    }
}
