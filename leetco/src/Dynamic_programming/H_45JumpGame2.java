package Dynamic_programming;

public class H_45JumpGame2 {

    //solution1 dynamic programming
    public int jump1(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        int index = 0;
        for(int i = 0; i < dp.length; i ++){
            for(int j = 1; j <= nums[i] && i + j < dp.length; j ++){
                if(dp[i + j] == 0){
                    dp[i + j] = dp[i] + 1;
                }else{
                    continue;
                }
            }
        }
        return dp[dp.length - 1];
    }

    //solution2 greedy
    public int jump2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int low = 0;
        int high = 0;
        int step = 0;
        while(high < nums.length - 1){
            int farthest = 0;
            for(int i = low; i <= high && i <= nums.length; i ++){
                farthest = Math.max(nums[i] + i, farthest);
            }
            low = high;
            high = farthest;
            step ++;
        }
        return step;
    }
}
