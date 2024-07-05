//https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int displacedStartIndex = nums.length - k;
        int[] result = new int[nums.length];
        for (int i = 0; i < k; i++) {
            result[i] = nums[displacedStartIndex + i];
        }
        int counter = 0;
        for (int i = k; i < nums.length; i++) {
            result[i] = nums[counter];
            counter++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
}
