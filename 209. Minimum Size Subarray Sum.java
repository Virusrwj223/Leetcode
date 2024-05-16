//https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    int cumSum;
    int start;
    int end;
    int minLen;
    public int minSubArrayLen(int target, int[] nums) {
        cumSum = 0;
        start = 0;
        end = 0;
        minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            end = i;
            cumSum += nums[i];
            while (cumSum >= target) {
                int tempLen = end - start + 1;
                if (tempLen < minLen) minLen = tempLen;
                cumSum -= nums[start];
                start++;
            }
        }
        if (minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}
