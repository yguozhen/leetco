package Array;

public class E_977SquaresOfASortedArray {
    //solution1 two pointers
    public int[] sortedSquares(int[] A) {
        if(A == null || A.length == 0){
            return A;
        }
        int left = 0;
        int right = A.length - 1;
        int[] result = new int[A.length];
        int index = A.length - 1;
        while(left <= right && left < A.length && right >= 0 && index >= 0){
            if(Math.abs(A[left]) >= Math.abs(A[right])){
                result[index--] = A[left] * A[left];
                left++;

            }else{
                result[index--] = A[right] * A[right];
                right--;
            }
        }
        return result;
    }
}
