'''
The question is:
Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.

Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.

Note that you need to maximize the answer before taking the mod and not after taking it.



The point of the question is:
to maximise the product of the sum of two subtrees.


My first approach to the problem was:
to compute the sum of each subtree which can be computed recursively. Then i attempted to take the product recursively by computing the product of the left subtree and the right subtree. 
But on hindsight, this misses the obvious requirement that the product of the subtrees must be such that their union reforms back all the nodes in the original tree.


My second approach to the problem was:
To make an array with the post-order traversal. Then i would calculate the number of children in each of the subtree. 
Then all i needed to do is to compute the sum of (a particular node in the array and the nodes immediately behind it corresponding to the number of children in the subtree) 
and the sum of (all other nodes) and take their products. 
However, this algorithm proves to be quite complex and requires the traversal of the tree two times.


The correct approach to the problem is:
To calculate the sum of each subtree and to find out the whole sum of all nodes in the tree. Then all that needs to be done is to find the max((totalSum - subtree) * subtree)


The conclusion is:
Whenever seeing a problem about ensuring that a split still results in the union of the original set, then it makes sense to compute the total arithmatic of the set.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        self.subtreeSum(root)
        self.totalSum = root.val
        self.res = 0
        self.maximiseProduct(root)
        return self.res % (10**9+7)

    def maximiseProduct(self, root):
        if root is None:
            return
        leftSum = root.left.val if root.left else 0
        rightSum = root.right.val if root.right else 0
        self.res = max(self.res, leftSum*(self.totalSum - leftSum), rightSum*(self.totalSum - rightSum))
        self.maximiseProduct(root.left)
        self.maximiseProduct(root.right)
        return


    def subtreeSum(self, root):
        if root is None:
            return 0
        root.val = (self.subtreeSum(root.left) + self.subtreeSum(root.right) + root.val) % (10**9+7)
        return root.val% (10**9+7)
