package Array;

public class E_53MaximumSubarray {
    //solution1 like dp
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int maxValue = nums[0];
        for(int i = 1; i < nums.length; i++){
            curMax = Math.max(curMax + nums[i], nums[i]);
            maxValue = Math.max(maxValue, curMax);
        }
        return maxValue;
    }
}
