package Dynamic_programming;

public class M_55JumpGame {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }else if(nums.length == 1){
            return true;
        }
        int temp = 0;
        for(int i = nums.length - 2; i >= 0; i --){
            if(nums[i] == 0){
                temp ++;
                continue;
            }
            if(nums[i] > temp){
                temp = 0;
            }else{
                temp ++;
            }
        }
        if(temp == 0){
            return true;
        }else{
            return false;
        }
    }
}
