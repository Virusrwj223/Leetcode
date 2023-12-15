class Solution:
    def rob(self, nums: List[int]) -> int:
        def my_rob(num):
            results = []
            updated_bounty_arr = list(map(lambda x: x,num))
            while max(updated_bounty_arr) > 0:
                counter = 0
                using_bounty_arr = list(map(lambda x: x,updated_bounty_arr))
                maxim = max(using_bounty_arr)
                pos = using_bounty_arr.index(maxim)
                using_bounty_arr[pos] = 0
                if pos- 1 >=0:
                    using_bounty_arr[pos-1] = 0
                if pos + 1 < len(num):
                    using_bounty_arr[pos+1] = 0
                maxim_sec = my_rob(using_bounty_arr)
                counter += maxim + maxim_sec
                ##results.append(counter)
                results = [counter]+results
                m_pos=updated_bounty_arr.index(maxim)
                updated_bounty_arr[m_pos] = 0
            if results == []:
                return 0
            else:
                return max(results)
        return my_rob(nums)
        
