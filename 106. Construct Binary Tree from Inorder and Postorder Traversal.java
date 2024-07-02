//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150
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
    Stack<Integer> nodeStack;
    TreeNode root;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.nodeStack = new Stack<>();
        for (int i = 0; i < postorder.length; i++) {
            this.nodeStack.push(postorder[i]);
        }
        int value = nodeStack.pop();
        this.root = new TreeNode(value);
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < inorder.length; i++) {
            if (value == inorder[i]) {
                found = true;
                continue;
            }
            if (!found) {
                leftArr.add(inorder[i]);
            } else {
                rightArr.add(inorder[i]);
            }
        }

        buildTreeHelper(this.root, "RIGHT", rightArr);
        buildTreeHelper(this.root, "LEFT", leftArr);
        return this.root;
    }

    public void buildTreeHelper(TreeNode parent, String direction, ArrayList<Integer> arr) {
        if (arr.size() == 0) return;
        int value = nodeStack.pop();
        TreeNode node = new TreeNode(value);
        if (direction.equals("RIGHT")) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < arr.size(); i++) {
            if (value == arr.get(i)) {
                found = true;
                continue;
            }
            if (!found) {
                leftArr.add(arr.get(i));
            } else {
                rightArr.add(arr.get(i));
            }
        }

        buildTreeHelper(node, "RIGHT", rightArr);
        buildTreeHelper(node, "LEFT", leftArr);
        
    }
}
