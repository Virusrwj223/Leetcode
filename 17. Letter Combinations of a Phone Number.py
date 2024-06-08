#https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-interview-150
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        keyboard = {
            "2": ["a","b","c"],
            "3": ["d","e","f"],
            "4": ["g","h","i"],
            "5": ["j","k","l"],
            "6": ["m","n","o"],
            "7": ["p","q","r","s"],
            "8": ["t","u","v"],
            "9": ["w","x","y","z"]
        }
        if len(digits) == 0:
            return []
        elif len(digits) == 1:
            firstDigit = digits[0]
            return keyboard[firstDigit]
        else:
            firstDigit = digits[0]
            strArr = keyboard[firstDigit]
            return self.helper(digits[1:],strArr)
    
    def helper(self, digits: str, results: List[str]) -> List[str]:
        keyboard = {
            "2": ["a","b","c"],
            "3": ["d","e","f"],
            "4": ["g","h","i"],
            "5": ["j","k","l"],
            "6": ["m","n","o"],
            "7": ["p","q","r","s"],
            "8": ["t","u","v"],
            "9": ["w","x","y","z"]
        }
        if len(digits) == 1:
            firstDigit = digits[0]
            strArr = keyboard[firstDigit]
            summer = lambda x,y:x+y
            temp = list(map(lambda x:[summer(i,x) for i in results],strArr))
            return [item for sublist in temp for item in sublist]
        else:
            firstDigit = digits[0]
            strArr = keyboard[firstDigit]
            summer = lambda x,y:x+y
            temp = list(map(lambda x:[summer(i,x) for i in results],strArr))
            tempResults = [item for sublist in temp for item in sublist]
            return self.helper(digits[1:], tempResults)



        
