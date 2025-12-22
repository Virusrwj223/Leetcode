'''
Recognise that the deletion of the columns for each violating element is independent
'''

class Solution(object):
    def minDeletionSize(self, strs):
        """
        :type strs: List[str]
        :rtype: int
        """
        counter = [1] * len(strs[0])
        best = 1
        
        for j in range(1, len(strs[0])):
            for i in range(j):
                ok = True
                for k in range(len(strs)):
                    if strs[k][i] <= strs[k][j]:
                        continue
                    else:
                        ok = not ok
                        break
                if ok:
                    counter[j] = max(counter[j], counter[i] + 1)
            best= max(best, counter[j])

        return len(strs[0]) - best



def main():
   candidiate = Solution().minDeletionSize
   print(1, candidiate(["ab"]) == 0)
   print(2, candidiate(["ba"]) == 1)
   print(3, candidiate(["abc"]) == 0)
   print(4, candidiate(["bac"]) == 1)
   print(5, candidiate(["abcd"]) == 0)
   print(6, candidiate(["zabc"]) == 1)
   print(7, candidiate(["aabc"]) == 0)
   print(8, candidiate(["azbc"]) == 1)

if __name__ == "__main__":
    main()
