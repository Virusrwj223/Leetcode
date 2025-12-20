class Solution:
    def minDeletionSize(self, strs):
        res = 0
        for i in range(len(strs[0])):
            for j in range(1, len(strs)):
                if strs[j][i] < strs[j-1][i]:
                    res += 1
                    break
        return res

def main():
    solution = Solution()
    print(1, solution.minDeletionSize(['a', 'b']) == 0)
    print(2, solution.minDeletionSize(['b', 'a']) == 1)
    print(3, solution.minDeletionSize(['aa', 'bb']) == 0)
    print(4, solution.minDeletionSize(['ab', 'bc']) == 0)
    print(5, solution.minDeletionSize(['ab','ba']) == 1)
    print(6, solution.minDeletionSize(['a']) == 0)
    print(7, solution.minDeletionSize(['a', 'a']) == 0)
    print(8, solution.minDeletionSize(['abc', 'def']) == 0)
    print(9, solution.minDeletionSize(['abc','abb']) == 1)
    print(10, solution.minDeletionSize(['abc', 'aaa']) == 2)
    print(11, solution.minDeletionSize(['def','abc']) == 3)

if __name__ == "__main__":
    main()
