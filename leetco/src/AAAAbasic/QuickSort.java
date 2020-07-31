package AAAAbasic;

public class QuickSort {
    //quick sort
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length <= 1){
            return nums;
        }
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int start, int end){
        if(end < start) return;
        int flag = nums[(start + end)/2];
        int left = start;
        int right = end;
        while(left <= right){
            while(left <= right && nums[left] < flag){
                left++;
            }
            while(left <= right && nums[right] > flag){
                right--;
            }
            if(left <= right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        sort(nums, start, right);
        sort(nums, left, end);
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
