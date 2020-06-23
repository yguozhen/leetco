package math;

public class E_69_Sqrtx {
    public int mySqrt(int x) {
        int start = 0;
        int temp = 1;
        int end = 0;
        while(x / temp > temp){
            temp = temp * 2;
        }
        end = temp;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(mid > x / mid){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(end == x/ end){
            return end;
        }else{
            return start;
        }


    }
}
