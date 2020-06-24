package design;

public class E_371SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int sum;
        int carry;
        do
        {
            sum=a^b;
            carry=(a&b)<<1;//进位需要左移一位
            a=sum;
            b=carry;
        }while(carry!=0);
        return sum;

    }
}
