package Dynamic_programming;

public class M_240SearchInA2DMatrix2 {

    //solution1 start point in the matrix[0][matrix[0/length - 1]
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] > target){
                j --;
            }else if(matrix[i][j] < target){
                i ++;
            }
        }
        return false;

    }
}
