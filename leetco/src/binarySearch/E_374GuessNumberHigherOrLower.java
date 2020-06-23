package binarySearch;

public class E_374GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int start = 0;
        int end = n;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(guess(mid) == -1){
                end = mid;
            }else if(guess(mid) == 1){
                start = mid;
            }else{
                return mid;
            }
        }
        if(guess(start) == 0){
            return start;
        }else {
            return end;
        }

    }
}
