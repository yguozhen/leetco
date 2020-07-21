package Array;

import java.util.LinkedList;
import java.util.List;

public class E_784LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new LinkedList<>();
        res.add(S);
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) >= 'a' && S.charAt(i) <= 'z'){
                int size = res.size();
                for(int j = 0; j < size; j++){
                    StringBuilder temp = new StringBuilder(res.get(j));
                    temp.setCharAt(i, (char)(temp.charAt(i) - 'a' + 'A'));
                    res.add(temp.toString());
                }
            }else if(S.charAt(i) >= 'A' && S.charAt(i) <= 'Z'){
                int size = res.size();
                for(int j = 0; j < size; j++){
                    StringBuilder temp = new StringBuilder(res.get(j));
                    temp.setCharAt(i, (char)(temp.charAt(i) - 'A' + 'a'));
                    res.add(temp.toString());
                }
            }

        }
        return res;
    }
}
