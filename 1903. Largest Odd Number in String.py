class Solution:
    def largestOddNumber(self, num):
      lst=[]
      for i in range(len(num)):
        lst.append(int(num[i]))
      lst.reverse()
      result_lst=[]
      for i in range(len(lst)):
          if lst[i]%2==1:
              result_lst = lst[i:]
              break

      result_str=""
      for i in result_lst:
          result_str = str(i) + result_str
      return(result_str)
        
