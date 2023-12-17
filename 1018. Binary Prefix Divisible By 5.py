class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        result = []
        for i in range(len(nums)):
            temp_arr = nums[0:i+1]
            temp_arr.reverse()
            counter = len(temp_arr)
            number = 0
            while counter>0:
                number += 2**(counter-1) * temp_arr[counter-1]
                counter -= 1
            if number%5 == 0:
                result.append(True)
            else:
                result.append(False)
        return result
        
