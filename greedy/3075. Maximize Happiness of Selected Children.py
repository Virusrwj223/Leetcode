class Solution(object):
    def maximumHappinessSum(self, happiness, k):
        """
        :type happiness: List[int]
        :type k: int
        :rtype: int
        """
        happiness.sort(key=lambda x: -x)
        res = 0
        for i in range(k):
            res += max(happiness[i] - i, 0)
        return res

def main():
    candidate = Solution().maximumHappinessSum
    print(1, candidate([1], 1) == 1)
    print(2, candidate([1, 2], 1) == 2)
    print(3, candidate([1, 2], 2) == 2)
    print(4, candidate([2, 1], 1) == 2)
    print(5, candidate([2, 1, 1], 3) == 2)
    print(6, candidate([1, 2, 3], 2) == 4)
    print(7, candidate([1, 1, 1, 1], 2) == 1)
    print(8, candidate([2, 3, 4, 5], 1) == 5)

if __name__ == "__main__":
    main()
