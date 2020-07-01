package binarySearch;

public class M_378KthSmallestELement {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0){
            return -1;
        }
        if(matrix.length == 1 && k == 1){
            return matrix[0][0];
        }
        int start = matrix[0][0];
        int end = matrix[matrix.length - 1][matrix.length - 1];
        int count = 0;
        while(start < end){
            int mid = start + (end - start) / 2;
            count = countSmaller(matrix, mid);

            if(count < k){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }

    public int countSmaller(int[][] matrix, int mid){
        int count = 0;
        int i = matrix.length - 1;
        int j = 0;
        while(i >= 0 && j < matrix[0].length){
            if(matrix[i][j] <= mid){
                count = count + i + 1;
                j ++;
            }else{
                i --;
            }
        }
        return count;
    }
}
