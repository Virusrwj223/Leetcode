'''
The question is:
You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':

if the ith character is 'Y', it means that customers come at the ith hour
whereas 'N' indicates that no customers come at the ith hour.
If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:

For every hour when the shop is open and no customers come, the penalty increases by 1.
For every hour when the shop is closed and customers come, the penalty increases by 1.
Return the earliest hour at which the shop must be closed to incur a minimum penalty.

Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.

The point of the question is:
to the find the optimal minimal position to maximise the non-penalty 

My first thought to implementing the question is:
To use a dp solution to check all possible starting and ending position. It turns out that I misread the question at this juncture and that the starting poistion is one at 0 because the entity is open from the begining.

On realising the mistake, my first correction was to use prefix sum to cache the penalty at a given point within the array. However, this approach is incorrect because I will need to account for the penalty of the customers coming in the future which a prefix sum on its own cannot capture.


The correct though to implementing the question is:
A small edit to the previous prefix sum approach will be to check for the number of customers that will come in the future by tabulating the results from the end of the array. Then I will check for the number of customers that do not come from the start. This allows for an easier way to tabulate the prefix sum of the penalty.

The difficulty in implemening the question is:
Because the entity can be closed after the customers have arrived, that means it is easier to keep a cache that is one larger than the number of customers. However, this resulted in off by one errors and confusion at different points of the algoithm

One way to maybe prevent this is to maintain comments stating the invariants especially at such edge cases
'''
class Solution:
    def bestClosingTime(self, customers: str) -> int:
        suffixYes = [0] * (len(customers) + 1)
        prefixNo = [0] * (len(customers) + 1)
        
        yesCounter = 0
        for i in range(len(customers), -1, -1):
            if i == len(customers):
                continue
            if customers[i] == 'Y':
                yesCounter += 1
            suffixYes[i] = yesCounter

        noCounter = 0
        for i in range(len(customers)): 
            prefixNo[i] = noCounter
            if customers[i] == 'N':
                noCounter += 1
        prefixNo[-1] = noCounter

        minPenalty = 100000
        res = 0
        for i in range(len(customers) + 1):
            penalty = suffixYes[i] + prefixNo[i]
            if penalty < minPenalty:
                minPenalty = penalty
                res = i
        return res

def main():
    candidate = Solution().bestClosingTime
    print(1, candidate("Y") == 1)
    print(2, candidate("N") == 0)
    print(3, candidate("YN") == 1)
    print(4, candidate("NY") == 0)
    print(5, candidate("YYNY") == 2)

if __name__ == "__main__":
    main()
