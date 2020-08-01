package Array;

public class M_209MinimumSizeSubarraySum {
    //solution1 brute
    //O(n^2)
    public int minSubArrayLen1(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length ; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum >= s){
                    result = Math.min(result, j - i + 1);
                    break;
                }
            }
        }
        if(result == Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }

    //solution2 two pointers
    //O(n)
    public int minSubArrayLen2(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for(int start = 0, end = 0; end < nums.length; end++){
            sum += nums[end];
            while(sum >= s){
                result = Math.min(result, end - start + 1);
                sum = sum - nums[start++];
            }
        }
        return result == Integer.MAX_VALUE? 0 : result;

    }

    //solution3
    //bianry search(size)
    //helper to sum the size to the end
    //O(nlogn)
    public int minSubArrayLen3(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = 1;
        int end = nums.length;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            boolean valid = helper(nums, mid) >= s;
            if(valid){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(helper(nums, start) >= s) return start;
        if(helper(nums, end) >= s) return end;
        return 0;
    }

    private int helper(int[] nums, int size){
        int sum = 0;
        for(int i = 0; i < size; i++){
            sum += nums[i];
        }
        int max = sum;
        for(int i = size; i < nums.length; i++){
            sum += nums[i] - nums[i - size];
            max = Math.max(sum, max);
        }
        return max;
    }
}
