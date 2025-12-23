'''
The question is:
You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.

Return this maximum sum.

Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.

The point of this question is to efficiently find the maximal non-overlapping values.

A naive implementation involves a nested loop searching for the next best value.
This can be imporved through sorting and binary searching

Errors made: Finding the best sequence of non-overlapping events that maximise value instead of the best of 2.

'''
class Solution(object):
    def maxTwoEvents(self, events):
        """
        :type events: List[List[int]]
        :rtype: int
        """
        events.sort(key = lambda x: x[0])
        maxCache = [-1] * len(events)
        maxima = -1
        for i in range(len(events) - 1, -1, -1):
            maxima = max(maxima, events[i][2])
            maxCache[i] = maxima
        
        res = -1
        for i in range(len(events)):
            eventEndTime = events[i][1]
            best = events[i][2]

            lo = i + 1
            hi = len(events)
            while lo < hi:
                mid = (lo + hi) // 2
                if events[mid][0] > eventEndTime:
                    hi = mid
                else:
                    lo = mid + 1
            j = lo

            if j < len(events):
                best += maxCache[j]
            res = max(res, best)

        return res






def main():
    candidate = Solution().maxTwoEvents
    print(1, candidate([[1, 2, 10], [3, 4, 10]]) == 20)
    print(2, candidate([[1, 2, 10], [3, 3, 10]]) == 20)
    print(3, candidate([[1, 2, 10], [2, 3, 10]]) == 10)
    print(4, candidate([[1, 2, 5], [1,1,1], [2,2,1]]) == 5)
    print(5, candidate([[1,2,5], [1,1,3], [2,2,2]]) == 5)
    print(6, candidate([[1,10,1], [1,1,10]]) == 10)
    print(7, candidate([[1,10,10], [1,1,1]]) == 10)
    print(8, candidate([[1,3,7], [2,4,3], [3,7,9]]) == 9)
    print(9, candidate([[8,9,3], [5,7,7], [1,6,9]]) == 12)
    print(10, candidate([[1,6,9], [5,7,7], [8,9,3]]) == 12)
    print(11, candidate([[1,3,2],[4,5,2],[2,4,3]]) == 4)
    print(12, candidate([[1,3,2],[4,5,2],[1,5,5]]) == 5)
    print(13, candidate([[1,5,3],[1,5,1],[6,6,5]]) == 8)

if __name__ == "__main__":
    main()
