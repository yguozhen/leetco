package Array;

import java.util.Arrays;

public class M_16ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return -1;
        }
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length -2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) == 0){
                    return target;
                }
                if(Math.abs(sum - target) < close){
                    close = Math.abs(sum - target);
                    res = sum;
                }
                if(sum < target){
                    left ++;
                    while(left < nums.length && nums[left] == nums[left - 1]){
                        left ++;
                    }

                }else{
                    right--;
                    while(right >= 0 && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
