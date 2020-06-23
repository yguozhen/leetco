package binarySearch;

public class M_62SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[start] < A[mid]){
                if(A[start] <= target && A[mid] >= target){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if(A[end] >= target && A[mid] <= target){
                    start = mid;
                }else{
                    end = mid;
                }

            }
        }

        if(A[start] == target){
            return start;
        }else if(A[end] == target){
            return end;
        }

        return -1;
    }
}
