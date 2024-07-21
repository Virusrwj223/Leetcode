//https://leetcode.com/problems/longest-substring-without-repeating-characters/
import java.util.*;
import java.lang.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Boolean> charExists = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxSize = 0;
        
        for (int i = 0; i < s.length(); i++){
            end = i;
            Character c = s.charAt(i);  
            if (charExists.containsKey(c)) {
                while (s.charAt(start) != c) {
                    charExists.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                charExists.put(c, true);
            }      
            int size = end-start + 1;
            if(size>maxSize) {
                System.out.println(start);
                System.out.println(end);
                maxSize = size;
            }
            System.out.println("^^^^^^^^^^^");
        }

        return maxSize;

        
    }
}
