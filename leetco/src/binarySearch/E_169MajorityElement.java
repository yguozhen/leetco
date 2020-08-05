package binarySearch;

import java.util.Arrays;
import java.util.HashMap;

public class E_169MajorityElement {
    //solution1 hashmap
    public int majorityElement1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else{
                map.put(num, 1);
            }
        }
        int result = 0;
        int max = 0;
        for(int i : map.keySet()){
            max = Math.max(max, map.get(i));
            if(max == map.get(i)){
                result = i;
            }
        }
        return result;
    }

    //solution2
    //because major element is big than n/2
    //when iteration finished, curmajor should be the major element
    public int majorityElement2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int count = 0;
        int curmajor = 0;
        for(int num : nums){
            if(count == 0){
                curmajor = num;
            }
            if(curmajor == num){
                count ++;
            }else{
                count--;
            }

        }
        return curmajor;
    }

    //solution3 sort and return nums.length/2 th number
    // LOL
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
