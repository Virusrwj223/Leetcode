class Solution:
    def sortSentence(self, s: str) -> str:
        unsorted_arr = s.split(" ")
        sorted_arr = [None]*len(unsorted_arr)
        for i in range(len(unsorted_arr)):
            sorted_arr[int(unsorted_arr[i][-1])-1] = unsorted_arr[i][0:len(unsorted_arr[i])-1]
        result = ""
        for i in sorted_arr:
            result+=i + " "

        return result.strip()
        
