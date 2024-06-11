//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-interview-150
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
import java.lang.*;
class Solution {
    Integer returnable;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        printInorder(root);
        return this.returnable;
    }
    
    void printInorder(TreeNode node) {
        if (node == null) {
            k--;
            return;
        }

        printInorder(node.left);

        if (k == 0 && returnable == null) this.returnable = node.val;

        // Now recur on right child
        printInorder(node.right);
    }

}
