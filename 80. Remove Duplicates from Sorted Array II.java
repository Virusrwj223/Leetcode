//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1 || nums.length == 2) return nums.length;
        int prevNum = nums[0];
        int numTimes = 0;
        int startedPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (currNum == prevNum) {
                numTimes++;
                if (numTimes > 2) {
                    startedPointer = i;
                    break;
                }
            } else {
                numTimes = 1;
            }
            prevNum = currNum;
        } 
        if (startedPointer == 0) return nums.length;
        for (int i = startedPointer + 1; i < nums.length; i++) {
            int currNum = nums[i];
            if (currNum != prevNum) {
                numTimes = 1;
                int temp = nums[startedPointer];
                nums[startedPointer] = nums[i];
                nums[i] = temp;
                startedPointer++;
                prevNum = currNum;
            } else if (currNum == prevNum && numTimes <= 1) {
                numTimes++;
                int temp = nums[startedPointer];
                nums[startedPointer] = nums[i];
                nums[i] = temp;
                startedPointer++;
            } else {
                numTimes++;
            }
        }
        return startedPointer;
    }
}
