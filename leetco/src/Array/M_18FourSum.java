package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M_18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i ++){
            for(int j = i + 1; j < nums.length; j ++){
                if((i == 0 || nums[i] != nums[i - 1] )&& (j == i + 1 || nums[j] != nums[j - 1])){
                    twoSum(nums, i, j, target, res);
                }
            }
        }
        return res;
    }

    public void twoSum(int[] nums, int i, int j, int target, List<List<Integer>> res){
        int low = j + 1;
        int high = nums.length - 1;
        while(low < high){
            int sum = nums[i] + nums[j] + nums[low] + nums[high];
            if(sum < target || (low > j + 1 && nums[low] == nums[low - 1])){
                low ++;
            }else if(sum > target || (high <nums.length - 1 && nums[high] == nums[high + 1])){
                high --;
            }else{
                res.add(Arrays.asList(nums[i], nums[j], nums[low++], nums[high--]));
            }
        }
    }
}
