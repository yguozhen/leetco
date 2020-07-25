package String;

import java.util.HashMap;

public class E_953VerifyingAnAlienDictionary {
    //solution1 hashmap
    public boolean isAlienSorted(String[] words, String order) {
        if(words == null || words.length <= 1){
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }
        for(int i = 1; i < words.length; i++){
            for(int j = 0; j < words[i - 1].length(); j++){
                if(j >= words[i].length()){
                    return false;
                }
                char pre = words[i - 1].charAt(j);
                char cur = words[i].charAt(j);
                if(pre == cur){
                    continue;
                }else if(map.get(pre) < map.get(cur)){
                    break;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
