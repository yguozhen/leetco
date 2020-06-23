package binarySearch;

public class E_35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        if(nums[start] >= target ){
            return start;
        }else if(nums[end] < target){
            return nums.length;
        }
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] == target){
            return start;
        }else{
            return end;
        }

    }
}
