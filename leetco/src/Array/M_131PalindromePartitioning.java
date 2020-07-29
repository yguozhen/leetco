package Array;

import java.util.ArrayList;
import java.util.List;

public class M_131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        List<String> partition = new ArrayList<>();
        helper(s, 0, partition, res);
        return res;
    }

    private void helper(String s, int startIndex, List<String> partition, List<List<String>> results){
        if(startIndex == s.length()){
            results.add(new ArrayList<String>(partition));
            return;
        }
        for(int i = startIndex; i < s.length(); i++){
            String subString = s.substring(startIndex, i + 1);
            if(!isPalindrome(subString)){
                continue;
            }
            partition.add(subString);
            helper(s, i + 1, partition, results);
            partition.remove(partition.size() - 1);
        }
    }
    private boolean isPalindrome(String s){
        for(int i = 0, j = s.length() - 1; i < s.length() - 1; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
