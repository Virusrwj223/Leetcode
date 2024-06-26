//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = prices[0];
        sell[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int pricePoint = prices[i];
            if (pricePoint <= buy[i-1]) {
                buy[i] = pricePoint;
                sell[i] = pricePoint;
            } else {
                buy[i] = buy[i-1];
                if (pricePoint >= sell[i-1]) sell[i] = pricePoint;
                else sell[i] = sell[i-1];
            }
        }
        int maxDiff = -1;
        for (int i = 0; i < buy.length; i++) {
            int diff = sell[i] - buy[i];
            if (diff > maxDiff) maxDiff = diff;
        }
        return maxDiff;
        
    }
}
