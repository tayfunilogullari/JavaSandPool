import java.io.IOException;
import java.util.*;

public class LongestObstacle {

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {

        int ans[] = new int[obstacles.length];
        ans[0] = 1;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(obstacles[0],1);
        for (int x = 1; x < obstacles.length; x++) {
            int max = 0;
            for (int y = obstacles[x]; y > 0; y--) {
                if (map.containsKey(y) && max < map.get(y)) {
                    max = map.get(y);
                }
            }
            max++;
            map.put(obstacles[x],max);
            ans[x] = max;
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {

        LongestObstacle sen = new LongestObstacle();
        int[] r = sen.longestObstacleCourseAtEachPosition(new int[]{5,1,5,5,1,3,4,5,1,4});
        System.out.println(Arrays.toString(r));
        //r = sen.minLength("ACBBD");
        //System.out.println(r);
    }

}
