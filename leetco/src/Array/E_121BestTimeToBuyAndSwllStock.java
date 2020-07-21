package Array;

public class E_121BestTimeToBuyAndSwllStock {
    //solution1 remember max number and min number
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for(int num : prices){
            if(num < min){
                min = Math.min(min, num);
            }
            max = Math.max(max, num - min);
        }
        return max;
    }
}
