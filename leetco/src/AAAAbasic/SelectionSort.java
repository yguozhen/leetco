package AAAAbasic;

public class SelectionSort {
    //selection sort
    public void selectionSort(int[] nums){
        if(nums == null || nums.length <= 1 ) return;
        for(int i = 0; i < nums.length; i++){
            int index = i;
            for(int j = i; j < nums.length; j++){
                if(nums[index] < nums[j]){
                    index = j;
                }
            }
            swap(nums, index, i);
        }

    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }



}
