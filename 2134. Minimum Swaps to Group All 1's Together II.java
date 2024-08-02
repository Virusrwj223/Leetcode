class Solution {
    public int minSwaps(int[] nums) {
        if (nums.length == 1) return 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) total++;
        }
        int sum = 0;
        int currentSum = 0;
        for (int i = 0; i < total; i++) {
            if (nums[i] == 0) currentSum++;
        }
        sum = currentSum;

        int start = 1;
        int end = total;
        // System.out.println(currentSum);
        
        while (start != 0) {
            start = start % nums.length;
            end = end % nums.length;
            if (nums[end] == 0) currentSum++;
            if (nums[start - 1] == 0) currentSum--;
            if (currentSum < sum) sum = currentSum;
            // System.out.println(start);
            // System.out.println(end);
            // System.out.println(currentSum);
            // System.out.println("^^^^^^^^^^^^");
            start++;
            end++;
            start = start % nums.length;
            end = end % nums.length;
            
        
        }
        return sum;
        
    }

}
