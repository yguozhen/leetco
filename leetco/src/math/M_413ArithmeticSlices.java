package math;

public class M_413ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {

        int count = 0;
        for(int s = 0; s < A.length - 2; s++){
            int d = A[s + 1] - A[s];
            for(int e = s + 2; e < A.length; e ++){
                if(A[e] - A[e - 1] == d){
                    count ++;
                }else{
                    break;
                }
            }
        }
        return count;
    }

    int temp = 0;
                while(i + 1 < expression.length() && expression.charAt(i + 1) <= '9' && expression.charAt(i + 1) >= '0'){
        temp = temp * 10 + (expression.charAt(i + 1) -'0');
        i = i + 1;

    }


}
