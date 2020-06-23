package math;

public class M_264uglyNumber2 {
    //solution1 brute
    public int nthUglyNumber(int n) {
        if(n == 0){
            return -1;
        }
        int index = 1;
        int number = 1;

        while(index <= n){
            int temp = number;
            while(temp > 1){
                if(temp % 2 == 0){
                    temp = temp /2;
                }else if(temp % 3 ==0){
                    temp = temp / 3;
                }else if(temp % 5 == 0){
                    temp = temp / 5;
                }else{
                    break;
                }
                if(temp == 1){
                    index ++;
                }
            }
            if(index == n){
                break;
            }
            number ++;
        }
        return number;
    }

    //solution2

}
