package math;

public class E_507PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num <= 0){
            return false;
        }

        int divisor = 1;
        int sum = 0;

        while(divisor * divisor <= num ){

            if(num % divisor == 0){
                sum = sum + divisor;
                if(divisor * divisor != num){
                    sum = sum + num/divisor;
                }
            }
            divisor ++;
        }
        if(sum == 2 * num){
            return true;
        }
        return false;
    }
}
