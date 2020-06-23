package math;

public class E_7ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while(x / 10 != 0){
            int temp = x%10;
            x = x/10;
            result = result * 10 + temp;
            if(result  > (Integer.MAX_VALUE/10) || result < (-Integer.MAX_VALUE/10)) return 0;
        }
        return result * 10 + x;
    }
}
