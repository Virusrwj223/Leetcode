//https://leetcode.com/problems/number-of-1-bits/description/?envType=featured-list&envId=top-interview-questions
class Solution {
    public int hammingWeight(int n) {
        String maxAmpStr = Integer.toBinaryString(n);
        char[] arr = maxAmpStr.toCharArray();
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') counter += 1;

        }
        return counter;
    }
}
