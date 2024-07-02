//https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-interview-150
import java.util.*;
import java.lang.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int pivot = nums[0];
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= pivot) left.add(nums[i]);
            else right.add(nums[i]);
        }
        if (left.size() + 1 == k) return pivot;
        else if (left.size() >= k) return helper(left, k);
        else return helper(right, k - left.size() - 1 );
    }

    public int helper(ArrayList<Integer> nums, int k) {
        int pivot = nums.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) >= pivot) left.add(nums.get(i));
            else right.add(nums.get(i));
        }
        if (left.size() + 1 == k) return pivot;
        else if (left.size() >= k) return helper(left, k);
        else return helper(right, k - left.size() - 1 );
    }
}
