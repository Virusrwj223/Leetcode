'''
THe question is:
Given two arrays nums1 and nums2.
Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).

My approach to the question is:
We can use dynamic programming to search all possible subsequences. Given that the pointers are always increasing, it guranatees that all possible results would not have a case where 
any two dot is formed by elements preceding one another.

THis is a standard DP question with a twist on the case of when an array is all negative. The key realisation must be that if both arrays have at least a positive elemnts, then the maximising
case must involve those positive elements and if both arrays have negative then, we can make two negatives to be a positive. So when one array is all negative and the other all positive, 
we will always get negative values which breaks our existing dp assumption of maximsing the number and the base case being 0.

In conclusion:
It is interesting to see that sometimes, 'hardcoding' a possible greoup of cases may actually be necessary because there is simply no better generalised abstraction.
'''

class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        self.nums1 = nums1
        self.nums2 = nums2
        self.cache = {}
        #THis is the difficulty. Need to realise that if any one array is all negative
        # then we need to take exactly one negative and one positive so that the 
        # dot product is minimal
        if max(nums1) < 0 and min(nums2) > 0:
            return max(nums1) * min(nums2)
        if min(nums1) > 0 and max(nums2) < 0:
            return min(nums1) * max(nums2)
        return self.maxDotProd(0, 0)

    def maxDotProd(self, i, j):
        if i >= len(self.nums1) or j >= len(self.nums2):
            return 0
        if (i, j) in self.cache:
            return self.cache[(i, j)]
        res = max(
            self.nums1[i] * self.nums2[j] + self.maxDotProd(i + 1, j + 1),
            # self.maxDotProd(i + 1, j + 1),
            self.maxDotProd(i, j + 1),
            self.maxDotProd(i + 1, j))
        self.cache[(i, j)] = res
        return res
            
