//https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
import java.lang.*;
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> resultArr = new ArrayList<>();
        int[] currentIntervalArr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] target = intervals[i];
            if (target[0] > currentIntervalArr[1]) {
                resultArr.add(currentIntervalArr);
                currentIntervalArr = target;
            } else {
                if (target[1] > currentIntervalArr[1]) {
                    currentIntervalArr[1] = target[1];
                }
            }
        }
        resultArr.add(currentIntervalArr);
        int[][] results = new int[resultArr.size()][];
        results = resultArr.toArray(results);
        return results;
    }
}
