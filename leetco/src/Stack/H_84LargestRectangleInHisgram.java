package Stack;

import java.util.Stack;

public class H_84LargestRectangleInHisgram {
    //solution1 brute method
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < heights.length; i++){
            int left = i - 1;
            int right = i + 1;
            int curmax = heights[i];
            while(left >= 0 || right < heights.length){
                if(left >= 0 && heights[left] >= heights[i]){
                    curmax += heights[i];
                    left--;
                }else if(right < heights.length && heights[right] >= heights[i]){
                    curmax += heights[i];
                    right++;
                }else{
                    break;
                }
            }
            result = Math.max(curmax, result);
        }
        return result;
    }

    //solution2 increasing stack
    public int largestRectangleArea2(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        for(int i = 0; i <= heights.length; i++){
            int cur = i == heights.length? -1 : heights[i];

            while(!stack.isEmpty() && cur <= heights[stack.peek()]){
                int high = heights[stack.pop()];
                int weight = stack.isEmpty()? i : i - stack.peek() - 1;
                result = Math.max(result, high * weight);
            }
            stack.push(i);
        }
        return result;
    }
}
