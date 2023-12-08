# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def tree2str(self, root):
        def traversal(tree):
            if  tree.left == None and tree.right == None:
                return str(tree.val)
            elif tree.left == None:
                return str(tree.val)+"()"+'('+traversal(tree.right)+')'
            elif tree.right == None:
                return str(tree.val)+'('+traversal(tree.left)+')'
            else:
                return str(tree.val)+'('+traversal(tree.left)+')'+'('+traversal(tree.right)+')'
        return(traversal(root))
        
