package Array;

import java.util.Arrays;

public class H_41FirstMissingPositive {
    //solution1 arrays.sort
    public int firstMissingPositive1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        Arrays.sort(nums);
        int flag = 1;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == flag){
                flag++;
            }else{
                continue;
            }
        }
        return flag;
    }

    //solution2 array
    public int firstMissingPositive2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int[] temp = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= temp.length || nums[i] <= 0){
                continue;
            }else{
                temp[nums[i]] = 1;
            }
        }
        for(int i = 1; i < temp.length; i++){
            if(temp[i] == 1){
                continue;
            }else{
                return i;
            }
        }
        return temp.length;
    }
}
