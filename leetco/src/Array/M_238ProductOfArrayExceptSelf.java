package Array;

public class M_238ProductOfArrayExceptSelf {
    //solution1 brute
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int[] res = new int[nums.length];
        int temp = 0;
        boolean haszero = false;
        int zeronum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                haszero = true;
                zeronum ++;
                continue;
            }else if(temp == 0){
                temp = 1 * nums[i];
            }else{
                temp = temp * nums[i];
            }

        }
        for(int i = 0; i < nums.length; i++){
            if(zeronum >1){
                return res;
            }
            if(haszero == true){
                if(nums[i] != 0){
                    res[i] = 0;
                }else{
                    res[i] = temp;
                }
            }else{
                res[i] = temp/nums[i];
            }
        }
        return res;
    }
}
