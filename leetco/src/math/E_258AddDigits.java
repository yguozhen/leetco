package math;

public class E_258AddDigits {
    public int addDigits(int num) {
        int temp = 0;
        return helper(num);

    }
    public int helper(int num){
        int temp = num % 10;

        while(num / 10 != 0){
            num = num / 10;
            temp = temp + num %10;


        }

        if(temp >= 10) return helper(temp);
        else return temp;

    }
}
