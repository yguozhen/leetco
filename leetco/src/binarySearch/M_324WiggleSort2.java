package binarySearch;

import java.util.Arrays;

public class M_324WiggleSort2 {
    //solution1
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = (n - 1) / 2;
        int index = 0;
        int[] temp = new int[n];
        for(int i = 0; i <= mid; i ++){
            temp[index] = nums[mid - i];
            if(index + 1 < n){
                temp[index + 1] = nums[n - 1 - i];
            }
            index += 2;
        }
        System.arraycopy(temp, 0, nums, 0, n);
    }

}
