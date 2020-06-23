package binarySearch;

public class E_28SearchA2DMatrix {

    public static boolean searchMatrix1(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return false;
        }
        if(matrix[0] == null || matrix[0].length == 0) return false;
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;

        while(start + 1 < end){
            int mid = start + (end - start)/2;
            int row = mid / matrix[0].length ;
            int col = mid % matrix[0].length ;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target ){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(matrix[start/matrix[0].length][start%matrix[0].length] == target){
            return true;
        }
        if(matrix[end/matrix[0].length][end%matrix[0].length] == target){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {8, 9, 10, 11},
                {13, 15, 17, 20},
        };
        int target = 20;
        boolean a = searchMatrix2(matrix, target);
        System.out.println((a));
    }
}
