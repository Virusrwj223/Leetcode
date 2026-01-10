'''
The question is:
Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.

My first approach to the question is:
to use dynamic programming because there is no better algorithm to know what to delete and what to keeep other than just brute-force checking of such.
In this approach, I attempted to keep an array of kept and removed characters and at the best case, find the minimum cost of the arrays that match. 
However, this became extremely unwiedly because it will take up lot of memory and time to build a new array at every recursion step.

My final aproach to the question is:
to think of a better base case. The key understanding here is that a base case is one where there are no more characters left in a string, then the string that still has characters need to be completely deleted.
That is because it does not make sense to attempt to keep and remove characters of one string when the other string is empty because they will never match.
Another understanding is how one can find out if the strings do match when some storage is not kept to check if the strings actually match. 
To do that, we simply need to split the cases. When the characters match, we will greedily move the pointers up. Otherwise, we will continue to the brute-force checking. 

In conclusion:
The key takeaway here is that it is very expensive to maintain an array of visited nodes and should be avoided and replaced with an algorithmic appraoch if possible.
'''

class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        self.s1 = s1
        self.s2 = s2
        return self.dp(0, 0)

    @cache
    def dp(self, s1Pointer, s2Pointer):
        if s1Pointer >= len(self.s1) and s2Pointer >= len(self.s2):
            return 0
        elif s1Pointer >= len(self.s1):
            return sum(map(lambda x: ord(x), self.s2[s2Pointer:]))
        elif s2Pointer >= len(self.s2):
            return sum(map(lambda x: ord(x), self.s1[s1Pointer:]))
        
        if self.s1[s1Pointer] == self.s2[s2Pointer]:
            return self.dp(s1Pointer + 1, s2Pointer + 1)
        else:
            return min(
                ord(self.s1[s1Pointer]) + ord(self.s2[s2Pointer]) + self.dp(s1Pointer + 1, s2Pointer + 1),
                ord(self.s2[s2Pointer]) + self.dp(s1Pointer, s2Pointer + 1),
                ord(self.s1[s1Pointer]) + self.dp(s1Pointer + 1, s2Pointer)
            )
