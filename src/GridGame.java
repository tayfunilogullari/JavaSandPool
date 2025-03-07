import java.io.IOException;

public class GridGame {

    public long gridGame(int[][] grid) {

        int index = (int) findBestIndex(grid, false);
        for (int i = 0; i < grid[0].length; i++) {
            if (index >= i) {
                grid[0][i] = 0;
            }
            if (index <= i) {
                grid[1][i] = 0;
            }
        }
        return findBestIndex(grid , true);
    }

    private long findBestIndex(int[][] grid , boolean whichRes) {

        long total = grid[0][0];
        for (int i = 0; i < grid[0].length; i++) {
            total += grid[1][i];
        }

        int res = 0;

        long newVal = total;
        for (int i = 1; i < grid[0].length; i++) {
            newVal += grid[0][i];
            newVal -= grid[1][i-1];
            if (total < newVal) {
                total = newVal;
                res = i;
            }
        }

        if (whichRes){
            return total;
        }
        return res;
    }



    public static void main(String[] args) throws IOException {

        GridGame sen = new GridGame();
        long r = sen.gridGame(new int[][]{{20,3,20,17,2,12,15,17,4,15}
                                         ,{20,10,13,14,15,5,2,3,14,3}});
        System.out.println(r);
        //r = sen.minLength("ACBBD");
        //System.out.println(r);
    }
}
