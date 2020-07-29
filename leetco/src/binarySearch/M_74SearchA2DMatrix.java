package binarySearch;

public class M_74SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
