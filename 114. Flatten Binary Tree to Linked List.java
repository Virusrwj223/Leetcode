//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-interview-150
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
    TreeNode result;
    TreeNode resultPointer;
    public void flatten(TreeNode root) {
        if (root == null) return;
        else if (root.left == null && root.right == null) return;
        
        this.result = root;
        this.resultPointer = this.result;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        if (result == null) {
            result = root;
        } else {
            resultPointer.right = root;
            resultPointer = resultPointer.right;
        }
       
        helper(left);
        helper(right);
        root = result;
        return;
    }
    public void helper(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        resultPointer.right = root;
        resultPointer = resultPointer.right;
        helper(left);
        helper(right);
    }
}
