package math;

public class E_67AddBinary {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        if(n < m) return addBinary(b, a);
        int max = Math.max(n,m);

        StringBuilder res = new StringBuilder();
        int temp = 0;
        int j = m - 1;
        for(int i = max - 1; i > -1; i --){
            if(a.charAt(i) == '1') temp ++;
            if(j > -1 && b.charAt(j--) == '1'){
                temp ++;

            }
            if(temp % 2 == 1){
                res.append('1');
            }
            else{
                res.append('0');
            }
            temp = temp /2;
        }

        if(temp == 1){
            res.append('1');
        }
        res.reverse();
        return res.toString();
  }
}
