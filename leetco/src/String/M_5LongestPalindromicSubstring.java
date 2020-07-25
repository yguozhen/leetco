package String;

public class M_5LongestPalindromicSubstring {
    //solution1 two pointers
    public String longestPalindrome1(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        String result = null;
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++){
            for(int start = i, end = i; start >= 0 && end < s.length(); start --, end ++){
                if(s.charAt(start) != s.charAt(end)){
                    break;
                }
                int newlen = end - start + 1;
                if(maxlen < newlen){
                    maxlen = newlen;
                    result = s.substring(start, end + 1);
                }
            }
            for(int start = i, end = i + 1; start >= 0 && end < s.length(); start --, end ++){
                if(s.charAt(start) != s.charAt(end)){
                    break;
                }
                int newlen = end - start + 1;
                if(maxlen < newlen){
                    maxlen = newlen;
                    result = s.substring(start, end + 1);
                }
            }
        }
        return result;
    }
}
