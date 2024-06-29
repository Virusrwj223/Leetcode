//https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
//Intuition: If I can reach the end, then there exists a path before it whose jump number is greater than 
// or equal to the number of steps needed to reach that number
class Solution {
    public boolean canJump(int[] nums) {
        return helper(nums, nums.length - 1);
    }
    public boolean helper(int[]nums, int end) {
        int counter = 1;
        boolean possible = false;
        if (end == 0) return true;
        for (int i = end - 1; i >= 0; i--) {
            if (nums[i] >= counter) { 
                possible = true;
                break;
            } else {
                counter++;
            }
        }
        if (possible) return helper(nums, end - counter);
        else return possible;
    }
}
