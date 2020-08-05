package Array;

public class M_11ContainerWithMostWater {

    //solution1 two pointers
    //
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int left = 0;
        int right = height.length - 1;
        while(left <= right){
            cur = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(cur, max);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
