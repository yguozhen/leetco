package math;

public class M_29DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long x = Math.abs((long)dividend), y = Math.abs((long)divisor);
        int  res = 0;

        while (x >= y){
            long tmp = y, p = 1;
            while(x >= (tmp << 1)){
                tmp <<= 1;
                p <<= 1;
            }
            x -= tmp;
            res += p;
        }

        return (int)(((dividend < 0) ^ (divisor < 0)) ? -res : res);
    }
}
