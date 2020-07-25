package String;

import java.util.HashSet;

public class M_3LongestSubstringWithoutRepeat {
    //solution1 hashset to record
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            HashSet<Character> map = new HashSet<>();
            int current = 0;
            for(int j = i; j < s.length(); j++){
                if(map.contains(s.charAt(j))){
                    break;
                }else{
                    map.add(s.charAt(j));
                    current ++;
                    result = Math.max(result, current);
                }
            }
        }
        return result;
    }
}
