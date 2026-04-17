class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0;

        for(int i = 0; i < prices.length - 1; i++){
            int buy = prices[i];
            for(int j = i + 1; j < prices.length; j++){
                int curSell = 0;
                if(prices[j] > buy){
                    curSell = prices[j] - buy;
                }
                sell = Math.max(curSell , sell);
            }
        }
        return sell;
    }
}
