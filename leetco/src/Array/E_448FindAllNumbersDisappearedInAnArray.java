package Array;

import java.util.ArrayList;
import java.util.List;

public class E_448FindAllNumbersDisappearedInAnArray {
    //solution1 find the index and make the nums[index] negative
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return list;
        }
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            nums[index] = - Math.abs(nums[index]);
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                list.add(i + 1);
            }
        }
        return list;
    }
}
