//https://leetcode.com/problems/maximum-sum-circular-subarray/?envType=study-plan-v2&envId=top-interview-150
import java.lang.*;
import java.util.*;
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        boolean all_neg = true;
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        int pseudoStart = 0;
        int pseudoEnd = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) all_neg = false;
            if (curr_sum < 0) {
                curr_sum = 0;
                pseudoStart = i;
                pseudoEnd = i;
            }
            curr_sum += nums[i];
            pseudoEnd = i;
            if (curr_sum > max_sum) {
                max_sum = curr_sum;
                start = pseudoStart;
                end = pseudoEnd;
            }
        }
        if(all_neg) return max_sum;
        int min_sum = Integer.MAX_VALUE;
        int total_sum = 0;
        curr_sum = 0;
        pseudoStart = 0;
        pseudoEnd = 0;
        start = 0;
        end = 0;
        for (int i = 0; i < nums.length; i++) {
            total_sum += nums[i];
            if (curr_sum > 0) {
                curr_sum = 0;
                pseudoStart = i;
                pseudoEnd = i;
            }
            curr_sum += nums[i];
            pseudoEnd = i;
            if (curr_sum < min_sum) {
                min_sum = curr_sum;
                start = pseudoStart;
                end = pseudoEnd;
            }
        }
        int pseudo_max_sum = total_sum - min_sum;
        return Math.max(max_sum, pseudo_max_sum);
    }
   
}
