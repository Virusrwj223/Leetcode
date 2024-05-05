/**
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=featured-list&envId=top-interview-questions

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
    int[] preorder;
	int[] inorder;
	int preorderCounter;


	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		this.inorder = inorder;
		this.preorderCounter = 0;

		TreeNode root = new TreeNode(this.preorder[preorderCounter]);
		int leftStart = 0;
		int leftEnd = -1;
		int rightStart = this.inorder.length;
		int rightEnd = this.inorder.length - 1;

		for (int i = 0; i < inorder.length; i++) {
			if (this.inorder[i] == this.preorder[preorderCounter]) {
				leftEnd = i -1;
				rightStart = i + 1;
				this.preorderCounter++;
				break;
			}
		}

		if (leftEnd >= leftStart && leftStart >= 0) root.left = helper(leftStart, leftEnd);
		if (rightStart <= rightEnd && rightEnd < inorder.length) root.right = helper(rightStart, rightEnd);
		return root;
	}

	public TreeNode helper(int start, int end) {
		
		if (start == end) {
            this.preorderCounter++;
            return new TreeNode(inorder[start]);
        }

		TreeNode root = new TreeNode(preorder[this.preorderCounter]);

		int leftStart = start;
		int leftEnd = -1;
		int rightStart = end + 1;
		int rightEnd = end;


		for (int i = start; i <= end; i++) {
			if (this.inorder[i] == preorder[this.preorderCounter]) {
				leftEnd = i - 1;
				rightStart = i + 1;
				this.preorderCounter++;
				break;
			}
		}

		if (leftEnd >= leftStart) root.left = helper(leftStart, leftEnd);
		if (rightStart <= rightEnd) root.right = helper(rightStart, rightEnd);
		return root;
	}	
}
