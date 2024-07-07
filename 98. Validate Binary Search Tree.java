//https://leetcode.com/problems/validate-binary-search-tree/?envType=study-plan-v2&envId=top-interview-150
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean valid;
    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        this.valid = true;
        helper(root, new long[]{Long.MIN_VALUE, Long.MAX_VALUE});
        return this.valid;
    }
    public void helper(TreeNode root, long[] range) {
        if (!this.valid) return;
        if (root == null) return;
        if (root.val <= range[0] || root.val >= range[1]) {
            this.valid = false;
            return;
        }
        TreeNode left = root.left;
        helper(left, new long[]{range[0], root.val});
        TreeNode right = root.right;
        helper(right, new long[]{root.val, range[1]});
    }
}
