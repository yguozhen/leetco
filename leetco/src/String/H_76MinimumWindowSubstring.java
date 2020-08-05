package String;

import java.util.HashMap;

public class H_76MinimumWindowSubstring {

    //solution1 hashmap + two count
    public String minWindow(String s, String t) {
        String result = "";
        if(t.length() > s.length()){
            return result;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char temp = t.charAt(i);
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp) + 1);
            }else{
                map.put(temp, 1);
            }
        }
        int j = 0;
        int min = Integer.MAX_VALUE;
        int countS = 0;
        int countT = t.length();
        for(int i = 0; i < s.length(); i++){
            while(countS < countT && j < s.length()){
                char temp = s.charAt(j);
                if(map.containsKey(temp)){
                    if(map.get(temp) > 0){
                        countS++;
                    }
                    map.put(temp, map.get(temp) - 1);
                }
                j++;
            }
            if(countT <= countS){
                if(j - i < min){
                    min = j - i;
                    result = s.substring(i, j);
                }
            }
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c) >= 0){
                    countS--;
                }
                map.put(c, map.get(c) + 1);
            }
        }
        return result;
    }
}
