//https://leetcode.com/problems/insert-interval/description/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] returnable = new int[intervals.length+1][];
        returnable[0] = newInterval;
        for (int i = 1; i < returnable.length; i++) {
            returnable[i] = intervals[i-1];
        }
        return merge(returnable);
    }
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
