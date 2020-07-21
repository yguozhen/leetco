package Array;

import java.util.Arrays;

public class E_561ArrayPartition1 {
    //solution1
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i += 2){
            sum += Math.min(nums[i], nums[i + 1]);
        }
        if(nums.length % 2 == 1){
            sum += nums[nums.length - 1];
        }
        return sum;
    }
}
