package heap;

public class M_215KthLargesElementInAnArray {

    //solution1 o(logn)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
