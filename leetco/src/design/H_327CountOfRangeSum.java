package design;

import java.util.TreeMap;

public class H_327CountOfRangeSum {

    //solution1
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        TreeMap<Long, Long> treeMap = new TreeMap<>();
        treeMap.put((long)0, (long)1);
        long sum = 0;
        long count = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            long from = sum - upper;
            long to = sum - lower;
            Map<Long, Long> sub = treeMap.subMap(from, true, to, true);
            for(Long value : sub.values()){
                count += value;
            }
            treeMap.put(sum, treeMap.getOrDefault(sum, (long)0) + 1);
        }
        return (int)count;
    }

    //solution2

}
