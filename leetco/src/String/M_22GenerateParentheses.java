package String;

import java.util.ArrayList;
import java.util.List;

public class M_22GenerateParentheses {
    //solution1 DFS recursive
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        helper(result, "", n, n);
        return result;
    }

    private void helper(List<String> list, String temp, int left, int right){
        if(left == 0 && right == 0){
            list.add(temp);
            return;
        }
        if(left > 0){
            helper(list, temp + "(", left - 1, right);
        }
        if(right > 0 && right > left){
            helper(list, temp + ")", left, right - 1);
        }
    }
}
