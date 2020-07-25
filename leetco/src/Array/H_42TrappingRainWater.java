package Array;

public class H_42TrappingRainWater {
    //solution1 two pointers
    public int trap1(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int leftheight = height[0];
        int rightheight = height[height.length - 1];
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while(left < right){
            if(height[left] < height[right]){
                left++;
                if(leftheight > height[left]){
                    result += leftheight - height[left];
                }else{
                    leftheight = height[left];
                }
            }else{
                right--;
                if(rightheight > height[right]){
                    result += rightheight - height[right];
                }else{
                    rightheight = height[right];
                }
            }
        }
        return result;
    }

    //solution2 an array list
    public int trap2(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int[] maxheight = new int[height.length + 1];
        maxheight[0] = 0;
        for(int i = 1; i < maxheight.length; i++){
            maxheight[i] = Math.max(maxheight[i - 1], height[i - 1]);
        }

        int area = 0;
        int max = 0;
        for(int i = height.length - 1; i > 0; i--){
            area += Math.min(max, maxheight[i]) > height[i] ? Math.min(max, maxheight[i]) - height[i] : 0;
            max = Math.max(max, height[i]);

        }
        return area;
    }
}
