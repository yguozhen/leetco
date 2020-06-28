package binarySearch;

public class M_33SearchInARotatedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[start] < nums[mid]){
                if(nums[start] <= target && nums[mid] >= target){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if(nums[end] >= target && nums[mid] <= target ){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }

        if(nums[start] == target){
            return start;
        }else if(nums[end] == target){
            return end;
        }
        return -1;
    }
}
