class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        t_arr = [None]*m
        for i in range(m):
            t_arr[i] = nums1[i]

        def sorter(arr1,arr2,a,b,counter):
            if a < m and b < n:
                if arr1[a] <= arr2[b]:
                    nums1[counter] = arr1[a]
                    return sorter(arr1,arr2,a+1,b,counter+1)
                else:
                    nums1[counter] = arr2[b]
                    return sorter(arr1,arr2,a,b+1,counter+1)

            elif a == m and b < n:
                nums1[counter] = arr2[b]
                return sorter(arr1,arr2,a,b+1,counter+1)
            
            elif b == n and a < m:
                nums1[counter] = arr1[a]
                return sorter(arr1,arr2,a+1,b,counter+1)

        sorter(t_arr,nums2,0,0,0)


        
       


        
