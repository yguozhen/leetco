package Array;

public class E_283MoveZeros {
    //solution1 swap
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int flag = 0;
        while(flag < nums.length && nums[flag] != 0){
            flag++;
        }
        for(int i = 0; i < nums.length; i++){
            if(flag >= i || nums[i] == 0){
                continue;
            }else{
                swap(nums, flag, i);
                flag++;
            }
        }
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
