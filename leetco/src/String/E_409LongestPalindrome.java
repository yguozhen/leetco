package String;

import java.util.HashSet;

public class E_409LongestPalindrome {
    //solution1 hashset space O(n)
    public int longestPalindrome1(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int count = 0;
        HashSet<Character> hashset = new HashSet<>();
        for(char c: s.toCharArray()){
            if(hashset.contains(c)){
                count ++;
                hashset.remove(c);
            }else{
                hashset.add(c);
            }
        }
        if(hashset.size() != 0) return count * 2 + 1;
        return count * 2;
    }

    //solution2
    public int longestPalindrome2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] store = new char[256];
        int res = 0;
        boolean flag = false;
        for(char temp : s.toCharArray()){
            if(store[temp] > 0){
                store[temp] --;
                res ++;
            }
            else{
                store[temp] ++;
            }
        }
        for(int i = 0; i < store.length; i++ ){
            if(store[i] != 0){
                flag = true;
            }
        }
        if(flag) return res * 2 + 1;
        return res * 2;
    }
}
