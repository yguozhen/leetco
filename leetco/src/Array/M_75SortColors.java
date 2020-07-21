package Array;

import java.util.HashMap;

public class M_75SortColors {
    //solution1 two pointers
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int i = 0, j = 0, k = nums.length - 1;
        while(j <= k){
            if(nums[j] == 0){
                swap(nums, i, j);
                i++;
                j++;
            }else if(nums[j] == 2){
                swap(nums, j, k);
                k--;
            }else{
                j++;
            }
        }
    }
    //solution2 hashmap calculate the number of different colors
    public void sortColors2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        int count0 = map.containsKey(0)?map.get(0):0;
        int count1 = map.containsKey(1)?map.get(1):0;
        int count2 = map.containsKey(2)?map.get(2):0;
        for(int i = 0; i < nums.length; i++){
            if(i < count0){
                nums[i] = 0;
            }else if(i - count0 < count1){
                nums[i] = 1;
            }else{
                nums[i] = 2;
            }
        }
    }
}
