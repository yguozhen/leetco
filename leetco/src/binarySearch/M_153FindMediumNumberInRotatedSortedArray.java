package binarySearch;

public class M_153FindMediumNumberInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }else if(nums.length == 1){
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        int target = nums[end];
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > target){
                start = mid;
            }else{
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
