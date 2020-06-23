package math;

public class E_367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num == 0){
            return true;
        }
        if(num < 0){
            return false;
        }
        int start = 0;
        int temp = 1;
        while(num / temp > temp){
            temp = temp * 2;
        }
        int end = temp;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(num / mid <=mid){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(start * start == num){
            return true;
        }else if(end * end == num){
            return true;
        }
        return false;

    }
}
