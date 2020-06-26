package binarySearch;

public class M_540SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start )/2;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                return nums[mid];
            }
            if(mid % 2 == 0){
                if(nums[mid] != nums[mid - 1]){
                    start = mid;
                }else{
                    end = mid;
                }
            }else{
                if(nums[mid] == nums[mid - 1]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        if(end % 2 == 0){
            if(nums[end] == nums[end - 1]){
                return nums[start];
            }else{
                return nums[end];
            }
        }else{
            if(nums[end] == nums[end - 1]){
                return nums[end];
            }else{
                return nums[start];
            }
        }


    }
}
