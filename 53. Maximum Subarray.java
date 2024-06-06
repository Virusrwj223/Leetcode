//https://leetcode.com/problems/maximum-subarray/?envType=study-plan-v2&envId=top-interview-150
import java.lang.Integer;
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = -1000000000;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += nums[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }
}
