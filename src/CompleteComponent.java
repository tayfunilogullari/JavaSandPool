import java.io.IOException;
import java.util.Arrays;

public class CompleteComponent {

    public int countCompleteComponents(int n, int[][] edges) {
        int res = 0;

        Arrays.sort(edges, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        int group = 0;
        for (int[] ed : edges) {
            if (arr[ed[0]] == -1 && arr[ed[1]] == -1) {
                arr[ed[0]] = group;
                arr[ed[1]] = group;
                group++;
            }
            else if (arr[ed[0]] == -1 && arr[ed[1]] == -1) {

            }

        }

        return res;
    }


    public static void main(String[] args) throws IOException {
        CompleteComponent cc = new CompleteComponent();

        int val = cc.countCompleteComponents(6 , new int[][] {
                {0,1},
                {0,2},
                {1,2},
                {3,4}
        });

        System.out.println(val);
    }
}
