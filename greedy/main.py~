from typing import List
import heapq

class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meetings.sort(key=lambda x: x[0])
        roomCounter = [0] * n

        minHeap = []
        heapPush = lambda x: heapq.heappush(minHeap, x)

        roomMinHeap = []
        roomHeapPush = lambda x: heapq.heappush(roomMinHeap, x)

        for i in range(n):
            roomHeapPush(i)

        first_room = heapq.heappop(roomMinHeap)
        roomCounter[first_room] += 1
        heapPush([meetings[0][1], first_room, meetings[0]])

        for i in range(1, len(meetings)):
            meeting = meetings[i]
            prevMeetingEnd, num, _ = None, None, None

            # if prevMeetingEnd <= meeting[0]:
            #     roomHeapPush(num)
            #     prevMeetingEnd = None
            #     num = None

            while len(minHeap) > 0 and minHeap[0][0] <= meeting[0]:
                prevMeetingEnd, num, _ = heapq.heappop(minHeap)
                roomHeapPush(roomNum)

            delay = 0
            if len(roomMinHeap) == 0:
                if prevMeetingEnd is None:
                    prevMeetingEnd, num, _ = heapq.heappop(minHeap)

                delay = -meeting[0] + prevMeetingEnd

                roomNum = num
            else:
                if prevMeetingEnd is not None:
                    heapPush([prevMeetingEnd, num, _])

                roomNum = heapq.heappop(roomMinHeap)

            meeting = [meeting[0] + delay, meeting[1] + delay]
            roomCounter[roomNum] = roomCounter[roomNum] + 1
            heapPush([meeting[1], roomNum, meeting])

        res = 0
        for i in range(1, n):
            if roomCounter[i] > roomCounter[res]:
                res = i
        return res



def main():
    candidate = Solution().mostBooked
    print(1, candidate(1, [[0, 10]]) == 0) 
    print(2, candidate(2, [[0, 10]]) == 0) 
    print(3, candidate(2, [[0, 5], [1, 4]]) == 0) 
    print(4, candidate(1, [[0, 5], [1, 4]]) == 0) 
    print(5, candidate(1, [[0, 5], [5, 9]]) == 0) 
    print(6, candidate(1, [[0, 5], [6, 9]]) == 0) 
    print(7, candidate(1, [[0, 5], [4, 9]]) == 0) 
    print(8, candidate(1, [[4, 9], [0, 5]]) == 0) 
    print(9, candidate(2, [[0,10],[1,5],[2,7],[3,4]]) == 0)
    print(10, candidate(3, [[1,20],[2,10],[3,5],[4,9],[6,8]]) == 1)
    print(11, candidate(4, [[18,19],[3,12],[17,19],[2,13],[7,10]]) == 0)
    print(12, candidate(4, [[19,20],[14,15],[13,14],[11,20]]) == 1)
    print(13, candidate(2, [[43,44],[34,36],[11,47],[1,8],[30,33],[45,48],[23,41],[29,30]]) == 1)
     


if __name__ == "__main__":
	main() 
