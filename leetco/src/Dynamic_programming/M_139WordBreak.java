package Dynamic_programming;

import java.util.List;

public class M_139WordBreak {
    //solution 1 dp
    private int getMaxLength(List<String> dict){
        int maxLength = 0;
        for(String word : dict){
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
    public boolean wordBreak(String s, List<String> dict) {
        if(s == null || s.length() == 0){
            return true;
        }
        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];

        canSegment[0] = true;
        for(int i = 1; i <= s.length(); i ++){
            canSegment[i] = false;
            for(int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength ++){
                if(!canSegment[i - lastWordLength]){
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if(dict.contains(word)){
                    canSegment[i] = true;
                    break;
                }
            }
        }
        return canSegment[s.length()];
    }
}
