/*
General Idea
Use binary serach to find longest subsequence
if subsequence not special AND less than 3 -> decrease mid
if subsequence speiacl AND more than 3 -> increase mid

Use sliding window through "bruteforce" approach to find number of occurences of a particular subsequence
*/

class Solution {
    String s;

    public int maximumLength(String s) {
        
        this.s = s;
        int lo = 0;
        int hi = s.length();
        boolean has3SpecialOfMidLen = false;

        while (lo <= hi && lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            has3SpecialOfMidLen = has3SubsequenceSpecial(mid);

            if(!has3SpecialOfMidLen) {
                hi = mid;
            } else {
                lo = mid;
            } 
        }
        has3SpecialOfMidLen = has3SubsequenceSpecial(lo + (hi - lo) / 2);
        if(!has3SpecialOfMidLen) {
            return -1;
        } else {
            return lo + (hi - lo) / 2;
        } 
    }

    public boolean has3SubsequenceSpecial(int length) { 
        if (length == 0) return false;
        for (int i = 0; i <= s.length() - length; i++) {
            String subsequence = s.substring(i, i + length);
            boolean isContinue = false;
            for (int j = 1; j < subsequence.length(); j++) {
                if (subsequence.charAt(0) != subsequence.charAt(j)) {
                    isContinue = true;
                    break;
                }
            }
            if (isContinue) continue;
            
            int count = 1;
        
            for (int j = i + 1; j <= s.length() - length; j++) {
                if (s.substring(j, j + length).equals(subsequence)) {
                    count++;
                } 
            }
            if (count >= 3) return true;
        }
        return false;
    }
}
