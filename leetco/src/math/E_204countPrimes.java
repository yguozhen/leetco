package math;

public class E_204countPrimes {
    public int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        int res = 0;
        boolean[] count = new boolean[n];
        for(int i = 2; i < n; i ++){
            if(count[i] == false){
                res ++;
                for(int j = 1; i * j < n; j ++){
                    count[j * i] = true;
                }

            }
        }
        return res;
    }
}
