package String;

public class H_10RegularMatchingExpression {
    public boolean isMatch(String s, String p) {
        if(s.length() == 0){
            return checkEmpty(p);
        }
        if(p.length() == 0){
            return false;
        }
        char s1 = s.charAt(0);
        char p1 = p.charAt(0);
        char p2 = '0';
        if(p.length() > 1){
            p2 = p.charAt(1);
        }
        if(p2 == '*'){
            if(isCompared(s1, p1)){
                //s move to next
                //* represent 0
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            }else{
                //not equal
                //* represent 0
                return isMatch(s, p.substring(2));
            }
        }else{
            if(isCompared(s1, p1)){
                //if equal then s and p move to next one
                return isMatch(s.substring(1), p.substring(1));
            }else{
                return false;
            }
        }
    }

    private boolean isCompared(char s, char p){
        return s == p || p == '.';
    }

    private boolean checkEmpty(String p){
        if(p.length() % 2 != 0){
            return false;
        }
        for(int i = 1; i < p.length(); i+=2){
            if(p.charAt(i) != '*'){
                return false;
            }
        }
        return true;
    }
}
