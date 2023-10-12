class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        def take(xs,n):
            if n==0:
                return []
            else:
                return [xs[0]]+take(xs[1:],n-1)
        def drop(xs,n):
            return xs if n == 0 else drop(xs[1:],n-1)
        def merge(xs,ys):
            if xs==[]:
                return ys
            elif ys==[]:
                return xs
            else:
                x=xs[0]
                y=ys[0]
                if x<y:
                    return [x]+merge(xs[1:],ys)
                else:
                    return [y]+merge(xs,ys[1:])
        def merge_sort(xs):
            if xs==[] or xs[1:]==[]:
                return xs
            else:
                mid = math.floor(len(xs)/2)
                return merge(merge_sort(take(xs,mid)),merge_sort(drop(xs,mid)))
        
        sorted_lst = merge_sort(nums1+nums2)
        if len(sorted_lst)%2==1:
            return sorted_lst[math.floor((len(sorted_lst)-1)/2)]
        else:
            small=int(((len(sorted_lst))/2)-1)
            big=int((len(sorted_lst))/2)
            return (sorted_lst[small]+sorted_lst[big])/2
