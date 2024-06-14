//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/?envType=study-plan-v2&envId=top-interview-150
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
import java.util.*;
import java.lang.*;
class Solution {
    List<List<Integer>> sol;
    int currLevel;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        this.sol = new ArrayList<List<Integer>>();
        this.currLevel = 0;
        List<TreeNode> iterable = new ArrayList<TreeNode>();
        if (root!=null){
            iterable.add(root);
            helper(iterable);
        }
        return sol;
    }

    public void helper(List<TreeNode> iterable) {
        List<Integer> subSol = new ArrayList<Integer>();
        List<TreeNode> nextIterable = new ArrayList<TreeNode>();
        if (iterable.size() > 0) {
            for (int i = 0; i < iterable.size(); i++) {
                TreeNode target = iterable.get(i);
                subSol.add(target.val);
                if (target.left != null) nextIterable.add(target.left);
                if (target.right != null) nextIterable.add(target.right);

            }
            if (currLevel % 2 != 0)Collections.reverse(subSol);
            currLevel++;
            sol.add(subSol);
            helper(nextIterable);
            
        }
    }
}
