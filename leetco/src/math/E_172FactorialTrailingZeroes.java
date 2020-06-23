package math;

public class E_172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        long temp = 5;
        int sum = 0;
        while(n >= temp){
            sum += (n/temp);
            temp = 5*temp;
        }
        return sum;
    }
}
