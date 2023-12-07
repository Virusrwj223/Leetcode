class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:


      def bin_search(lo,hi, arr):
        if nums[0]==nums[-1] and nums[0]==target:
            return [0,len(nums)-1]
        else:
            mid = int((lo+hi)/2)
            if lo == mid or hi == mid:
                return [-1,-1]
            if target == nums[mid]:
                a = bin_search(lo,mid,arr[lo:mid])
                b = bin_search(mid,hi,arr[mid:hi])
                if a == [-1,-1]:
                    if b == [-1,-1]:
                        return [mid]
                    else:
                        return [mid,b[-1]]
                else:
                    if b == [-1,-1]:
                        return [a[0],mid]
                    else:
                        return [a[0],mid,b[-1]]
            elif target<nums[mid]:
                return bin_search(lo, mid, arr)
            else:
                return bin_search(mid,hi, arr)

      output = bin_search(0,len(nums), nums)
      return( [output[0],output[-1]])
