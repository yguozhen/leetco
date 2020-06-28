package binarySearch;

public class H_154FindMinimumInRotatedArray2 {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }else if(nums.length == 1){
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int target = end;
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[target]){
                start = mid;
            }else if(nums[mid] < nums[target]){
                end = mid;
            }else{
                end = end - 1;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
