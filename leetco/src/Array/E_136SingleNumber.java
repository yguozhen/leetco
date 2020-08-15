package Array;

import java.util.HashMap;

public class E_136SingleNumber {

    //solution1 hashmap
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            map.putIfAbsent(nums[i], 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }
        return -1;
    }

    //solution2 XOR method
    //exclusive or
    //x^x=0，x^0=x
    public int singleNumber2(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }
}
