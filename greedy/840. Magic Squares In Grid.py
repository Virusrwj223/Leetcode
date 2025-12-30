from typing import List
import itertools

class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        res = 0
        for i in range(len(grid) - 2):
            for j in range(len(grid[0]) - 2):
                subgrid = grid[i:i+3]
                subgrid = [row[j:j+3] for row in subgrid]
                flattened_subgrid = list(itertools.chain.from_iterable(subgrid))
                if len(list(filter(lambda x: x == 0 or x > 9, flattened_subgrid))) != 0:
                    continue
                if len(list(set(flattened_subgrid))) != 9:
                    continue
                row1 = sum(subgrid[0])
                row2 = sum(subgrid[1])
                row3 = sum(subgrid[2])
                col1 = subgrid[0][0] + subgrid[1][0] + subgrid[2][0]
                col2 = subgrid[0][1] + subgrid[1][1] + subgrid[2][1]
                col3 = subgrid[0][2] + subgrid[1][2] + subgrid[2][2]
                d1 = subgrid[0][0] + subgrid[1][1] + subgrid[2][2]
                d2 = subgrid[0][2] + subgrid[1][1] + subgrid[2][0]
                if len(list(filter(lambda x: x != row1, [row1, row2, row3, col1, col2, col3, d1, d2]))) != 0:
                    continue
                res += 1
        return res


def main():
    candidate = Solution().numMagicSquaresInside
    print(1, candidate([[4,3,8], [9,5,1], [2,7,6]]) == 1)
    print(1, candidate([[1,2,3], [4,5,6], [7,8,9]]) == 0)
    print(1, candidate([[1,1,3], [4,5,6], [7,8,9]]) == 0)
    print(2, candidate([[1,2,3], [4,0,6], [7,8,9]]) == 0)
    print(3, candidate([[1,2,3], [4,5,6], [7,8,15]]) == 0)
    print(4, candidate([[1,11,3], [4,5,6], [7,8,9]]) == 0)
    print(5, candidate([[1,2,3]]) == 0)
    print(6, candidate([[1], [2], [3]]) == 0)
    print(7, candidate([[4,3,8,4],[9,5,1,9],[2,7,6,2]]) == 1)
    print(8, candidate([[2,7,6],[1,5,9],[4,3,8]]) == 0)

if __name__ == "__main__":
    main()
