/*
The main idea here is to maximise the formula:
-B1 + S1 - B2 + S2

we first look at P1 = -B1 + S1
to maximise P1, we need to minimise the B1 and maximise the S1 in disjoint sets
so we do a single pass where we find the minima of B1 and the maxima of S1 and calculate the profit

then we look at P1.5 = P1 - B2
to maximise P1.5, we maximise P1 and minimse B2 while ensuring a crossover between partitions
so we do a single pass where we find the maxima of P1 ONLY and calculate the profit

then we look at P2 = P1.5 + S2
to maximise P2, we maximise P1.5 and misinse S2 while ensuring a crossover between partions
so we do a single pass where we find the maxima of P1.5 ONLY and calculate the profit

We finally look for the highest profit in the array
*/

class Solution {
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        int[] p = new int[prices.length];
        int[] max2 = new int[prices.length];
        int[] min2 = new int[prices.length];
        int[] p3 = new int[prices.length];

        int currMin = Integer.MAX_VALUE;
        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            currMin = (int)Math.min(currMin, prices[i]);
            min[i] = currMin;
            if (i - 1 < 0 || currMin != min[i - 1]) {
                currMax = prices[i];
            }
            currMax = (int)Math.max(currMax, prices[i]);
            p[i] = currMax - min[i];
            if (i - 1 < 0) {
                max2[i] = p[i];
            } else {
                max2[i] = (int)Math.max(p[i], max2[i - 1]);
            }
            
            int p2 = max2[i] - prices[i];
            if (i - 1 < 0) {
                min2[i] = p2;
            } else {
                min2[i] = (int)Math.max(p2,min2[i - 1]);
            }

            int res = min2[i] + prices[i];
            if (i - 1 < 0) {
                p3[i] = res;
            } else {
                p3[i] = (int)Math.max(res,p3[i - 1]);
            }
            
        }

        return p3[p3.length - 1];
    }
}
