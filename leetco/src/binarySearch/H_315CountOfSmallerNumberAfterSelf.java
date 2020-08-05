package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H_315CountOfSmallerNumberAfterSelf {
    //solution1
    //create a arraylist to store the traversed number
    //the list index is the count number
    //helper is use to get the index of target in sorted
    public int helper(List<Integer> sorted, int target){
        if(sorted.size() == 0){
            return 0;
        }
        int start = 0;
        int end = sorted.size() - 1;
        if(sorted.get(start) >= target){
            return 0;
        }
        if(sorted.get(end) < target){
            return end + 1;
        }
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(sorted.get(mid) < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(sorted.get(start) == target){
            return start;
        }
        return end;
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        if(nums == null){
            return null;
        }
        List<Integer> sorted = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i --){
            int index = helper(sorted, nums[i]);
            sorted.add(index, nums[i]);
            ans[i] = index;
        }
        return Arrays.asList(ans);
    }
}
