package math;

public class M_50Powxn {
    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1.0;
        }
        long N = n;
        if(N < 0){
            x = 1/x;
            N = - N;
        }
        double ans = 1;
        double temp = x;

        for(long i = N; i > 0; i = i / 2){
            if((i%2) == 1){
                ans = ans * temp;
            }
            temp = temp * temp;
        }
        return ans;



    }
}
