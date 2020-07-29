package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M_47Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        helper(result, list, visited, nums);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] visited, int[] nums){
        if(list.size() == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)){
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);
            helper(result, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}
