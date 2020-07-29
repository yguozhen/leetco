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

    //solution2 find the current min
    public int nthUglyNumber2(int n) {
        int[] array = new int[1690];
        int n2 = 0, n3 = 0, n5 = 0;
        array[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Math.min(Math.min(array[n2] * 2, array[n3] * 3), array[n5] * 5);
            array[i] = min;
            if(min == array[n2] * 2) n2++;
            if(min == array[n3] * 3) n3++;
            if(min == array[n5] * 5) n5++;
        }
        return array[n - 1];
    }
}
