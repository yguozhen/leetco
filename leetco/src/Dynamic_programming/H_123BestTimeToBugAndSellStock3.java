package Dynamic_programming;

public class H_123BestTimeToBugAndSellStock3 {
    //solution1 dp to calculate
    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int k = 2;
        int[][] dp = new int[k + 1][prices.length];
        int maxdiff = 0;
        for(int i = 1; i < dp.length; i++){
            maxdiff = -prices[0];
            for(int j = 1; j < dp[0].length; j++){
                maxdiff = Math.max(maxdiff, dp[i-1][j-1] - prices[j]);
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxdiff);
            }
        }
        return dp[k][prices.length - 1];
    }
}
