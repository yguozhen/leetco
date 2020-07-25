package Array;

public class M_560SubarraySumEqualsK {
    //solution1 brute
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    result++;
                }else{
                    continue;
                }
            }
        }
        return result;
    }
}
