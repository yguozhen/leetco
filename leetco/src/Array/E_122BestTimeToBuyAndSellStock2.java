package Array;

public class E_122BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int[] prefix = new int[prices.length + 1];
        int res = 0;
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i - 1];
            if(diff > 0){
                res = res + diff;
            }
        }
        return res;
    }
}
