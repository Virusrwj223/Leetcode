# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        sorted_arr= [] 
        def rearragnagement(num):
            
            for i in range(1,len(sorted_arr)):
                if  num < sorted_arr[i] and num < sorted_arr[i-1]:
                    sorted_arr.insert(0,num)
                    break
                elif  num < sorted_arr[i] and num >= sorted_arr[i-1]:
                    sorted_arr.insert(i,num)
                    break
                elif i == len(sorted_arr)-1 and num >= sorted_arr[i]:
                    sorted_arr.append(num)
                    break

            

        def scan(lst):
            if lst == None:
                pass
            else:
                if len(sorted_arr) == 0:
                    sorted_arr.append(lst.val)
                    return scan(lst.next)
                elif len(sorted_arr) == 1:
                    if lst.val < sorted_arr[0]:
                        sorted_arr.insert(0,lst.val)
                        return scan(lst.next)
                    else:
                        sorted_arr.append(lst.val)
                        return scan(lst.next)
                    
                else:
                    rearragnagement(lst.val)
                    return scan(lst.next)
        def results(counter,lst):
            if lst!=None:
                lst.val = sorted_arr[counter]
                return results(counter+1,lst.next)
        scan(head)
        results(0,head)
        return head 
