import java.util.*;
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int counter = 1;
        int min = nums[0];
        int max = min + k;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                counter++;
                min = nums[i];
                max = min + k;
            }
        }
        return counter;
    }
}
