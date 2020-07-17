package Array;

import java.util.Arrays;

public class M_259ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int best = 0;
        for(int i=0;i<nums.length;i++){
            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=nums[left]+nums[right]+nums[i];
                //int t1=target-sum;
                if(sum>=target){
                    right--;
                    left=i+1;
                }else{
                    if(left + 1 == right){
                        right --;
                        left = i + 1;
                    }else{
                        left++;
                    }
                    best++;


                }
            }
        }

        return best;
    }
}
