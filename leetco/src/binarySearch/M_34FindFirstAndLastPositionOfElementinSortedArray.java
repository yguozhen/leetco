package binarySearch;

public class M_34FindFirstAndLastPositionOfElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return new int[]{-1, -1};
        }
        if(nums[0] > target || target > nums[nums.length - 1]){
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[2];
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[start] == target){
            result[0] = start;
        }else if(nums[end] == target){
            result[0] = end;
        }else{
            return new int[]{-1, -1};
        }
        start = 0;
        end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] <= target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[end] == target){
            result[1] = end;
        }else if(nums[start] == target){
            result[1] = start;
        }
        return result;
    }
}
