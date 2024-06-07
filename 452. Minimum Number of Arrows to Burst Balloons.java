//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(e -> e[1]));
        int counter = 1;
        int[] target = points[0];
        for (int i = 1; i < points.length; i++) {
            //System.out.println(Arrays.toString(target));
            //System.out.println(Arrays.toString(points[i]));
            int[] casis = points[i];
            if (target[1] < casis[0]) {
                counter++;
                target = casis;
            }
            //else target = casis;

        }        
        return counter;
    }
}
