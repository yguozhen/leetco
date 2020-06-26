package binarySearch;

public class M_162FindPeekElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return 0;
        }
        for(int i = 0; i < nums.length; i ++){
            if(i >0 && nums[i] <= nums[i - 1]){
                continue;
            }else if(i < nums.length - 1 && nums[i] <= nums[i + 1]){
                continue;
            }else{
                return i;
            }

        }
        return -1;
    }
}
