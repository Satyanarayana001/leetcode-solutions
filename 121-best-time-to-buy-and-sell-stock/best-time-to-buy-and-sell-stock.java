class Solution {
    public int maxProfit(int[] prices) {
       /* int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < buy){
                buy = prices[i];
            }
            else if (prices[i] - buy > profit){
                profit = prices[i] - buy;
            }
        }
        return profit; */
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}