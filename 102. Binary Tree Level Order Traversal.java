//https://leetcode.com/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-interview-150
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
    List<List<Integer>> answer;
    public List<List<Integer>> levelOrder(TreeNode root) {
        answer = new ArrayList<List<Integer>>();
        List<Integer> valSubList = new ArrayList<Integer>();
        List<TreeNode> subList = new ArrayList<TreeNode>();
        if(root == null) return answer;
        valSubList.add(root.val);
        subList.add(root);
        answer.add(valSubList);
        helper(subList);
        return answer;
        
    }

    public void helper(List<TreeNode> rootArr) {
        if (rootArr.size() == 0) return;
        List<Integer> valSubList = new ArrayList<Integer>();
        List<TreeNode> subList = new ArrayList<TreeNode>();
        for (int i = 0; i < rootArr.size(); i++) {
            TreeNode left = rootArr.get(i).left;
            TreeNode right = rootArr.get(i).right;
            if (left != null) {
                subList.add(left);
                valSubList.add(left.val);
            }
            if (right != null) {
                subList.add(right);
                valSubList.add(right.val);
            }
        }
        if (valSubList.size() != 0 ){
            answer.add(valSubList);
            helper(subList);
        }
        
    }
}
