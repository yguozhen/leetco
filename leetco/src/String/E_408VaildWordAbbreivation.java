package String;

public class E_408VaildWordAbbreivation {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word.length() == 0 && abbr.length() == 0){
            return true;
        }else if(word.length() == 0 || abbr.length() == 0){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i < word.length() && j < abbr.length()){
            if(abbr.charAt(j) == word.charAt(i)){
                i ++;
                j ++;
                continue;
            }
            if(abbr.charAt(j) <= '0' || abbr.charAt(j) > '9'){
                return false;
            }
            int index = j;
            while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                j ++;
            }
            int num = Integer.valueOf(abbr.substring(index, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }
}
