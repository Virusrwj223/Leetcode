# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root):
        master_lst=[]
        def inorder(tree):
            if tree == []:
                return []
            elif tree == None:
                return None
            elif tree.left == None and tree.right == None:
                return [tree.val]
            elif tree.left == None:
                right = inorder(tree.right)
                value = [tree.val]
                answer = value+right
                return answer
            elif tree.right == None:
                value = [tree.val]
                left = inorder(tree.left)
                answer = left+value
                return answer
            else:
                right = inorder(tree.right)
                value = [tree.val]
                left = inorder(tree.left)
                answer = left+value+right
                return answer

        return inorder(root)
