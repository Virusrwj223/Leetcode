//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150
// Intuition: only count the upwards trending numbers between any two intervals. 
// This is b/c any profit is guaranteed by any adjacent rise in prices
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }
}
