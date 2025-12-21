'''
Errors: Fininding boolean isLex, Thought 'a' > 'b'
The question is:

You are given an array of n strings strs, all of the same length.

We may choose any deletion indices, and we delete all the characters in those indices for each string.

For example, if we have strs = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef", "vyz"].

Suppose we chose a set of deletion indices answer such that after deletions, the final array has its elements in lexicographic order (i.e., strs[0] <= strs[1] <= strs[2] <= ... <= strs[n - 1]). Return the minimum possible value of answer.length.

The reason for asking this question is:
To be able to return a minimum sorted array after deleting violating columns.

My first approach involved a simple recursive structure to identify the number of violating columns independently. However this missed an edge case as observed in the key insight

The key insight of this problem:
Is recognising that one must account for a state that was previously passed when one state is deleted as that may have a cascading effect on the previously passed state. The main idea in this case is then to keep a list of deleted columns and go back to previously passed state to check if the newly deleted column has any new effect on the previously passed state.

This naturally brings the idea of continuations that my second approach uses where the idea is to store the point of a program that was once passed and resume that program execution with the new context of newly deleted columns.

In conclusion, the questions enables the understanding of being mindful of how one recursion branch may affect another and to think naturally on what one can do in such a situation rather than rely on fancy mathematical tricks.
'''

class Solution(object):
    def minDeletionSize(self, strs):
        """
        :type strs: List[str]
        :rtype: int
        """
        self.strs = strs
        self.banned = set()
        self.continuations = []
        self.continuations.append((0, len(strs), 0, 0))
        while len(self.continuations) != 0:
            continuation = self.continuations.pop()
            self.numLex(continuation[0], continuation[1], continuation[2], continuation[3])
        return len(list(self.banned))

    def numLex(self, rStart, rEnd, col, numContinuation):
        if col >= len(self.strs[0]):
            return
        if col in self.banned:
            return self.numLex(rStart, rEnd, col + 1, 0)

        if numContinuation > 0 and col not in self.banned:
            return

        i = rStart + 1
        while i < rEnd:
            if self.strs[i - 1][col] < self.strs[i][col]:
                i += 1
                continue
            elif self.strs[i - 1][col] > self.strs[i][col]:
                self.banned.add(col)
                return self.numLex(rStart, rEnd, col + 1, numContinuation)
            
            jStart = i - 1
            jEnd = i + 1
            while jEnd < rEnd and self.strs[jEnd][col] == self.strs[i][col]:
                jEnd += 1
            self.numLex(jStart, jEnd, col + 1, numContinuation)
            i = jEnd

        self.continuations.append((rStart, rEnd, col, numContinuation + 1))

def main():
    candidate = Solution().minDeletionSize
    print(1, candidate(["a", "b"]) == 0)
    print(2, candidate(["b", "a"]) == 1)
    print(3, candidate(["ab", "ac"]) == 0)
    print(2, candidate(["ac", "ab"]) == 1)
    print(2, candidate(["bb", "ab"]) == 1)
    print(4, candidate(["bb", "aa"]) == 2)
    print(5, candidate(["acd","abc"]) == 2)
    print(6, candidate(["ab", "ac", "ba", "ca", "cb"]) == 0)
    print(7, candidate(["ab", "aa", "ba", "ca", "cb"]) == 1)
    print(8, candidate(["ca", "bb", "ac"]) == 1)
    print(9, candidate(["xc", "yb", "za"]) == 0)
    print(10, candidate(["zyx", "wvu", "tsr"]) == 3)
    print(11, candidate(["vdy","vei","zvc","zld"]) == 2)
    print(12, candidate(["aab","aba","bda","bab"]) == 2)

if __name__ == "__main__":
    main()
