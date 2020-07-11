package String;

import java.util.List;

public class E_422ValidWordSquare {
    //solution1
    public boolean validWordSquare1(List<String> words) {
        if(words == null || words.size() == 0){
            return true;
        }
        for(int i = 0; i < words.size(); i++){
            int size = words.get(i).length();
            for(int j = 0; j < size; j ++){
                if(j >= words.size() || i >= words.get(j).length() ){
                    return false;
                }
                if(words.get(i).charAt(j) == words.get(j).charAt(i)){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
