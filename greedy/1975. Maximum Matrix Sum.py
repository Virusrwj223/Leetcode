'''
if there is an odd number of negative elements, then exactly one of them cannot be flipped to a positive number.
So it makes sense to choose this number to be the largest negative number in order to maximise the array.
We can easily then just think of all the remianing numbers to be positive and take their sum and subtract the largest negative number from it.
A special case are zeros. Since negation have no effect on them, in their presence, we can immediately just take the absolute sum of the whole matrix.
'''

class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        absSum = 0
        numNeg = 0
        smallestElement = abs(matrix[0][0])
        existsZero = False

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                num = matrix[i][j]
                if num < 0:
                    numNeg += 1
                existsZero = existsZero or num == 0
                absSum += int(abs(num))
                smallestElement = int(min(smallestElement, abs(num)))
        
        if numNeg % 2 == 0 or existsZero:
            return absSum
        else:
            # print(absSum, smallestElement)
            return absSum - smallestElement * 2
        
