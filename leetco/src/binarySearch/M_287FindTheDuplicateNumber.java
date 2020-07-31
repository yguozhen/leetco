package binarySearch;

import java.util.Arrays;

public class M_287FindTheDuplicateNumber {
    //solution1 brute
    public int findDuplicate1(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                return nums[i];
            }
        }
        return -1;
    }

    //solution2 binary search
    public int findDuplicate2(int[] nums) {
        if(nums == null || nums.length <= 1){
            return -1;
        }
        int start = 1;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) /2;
            //should be <=
            //because if [2,2,2] error
            if(count(nums, mid) <= mid){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(count(nums, start) <= start){
            return end;
        }
        return start;
    }

    private int count(int[] nums, int label){
        int number = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= label){
                number ++;
            }
        }
        return number;
    }
}
