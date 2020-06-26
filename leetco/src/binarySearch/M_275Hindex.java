package binarySearch;

public class M_275Hindex {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int start = 0;
        int end = citations.length - 1;
        int count = 0;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            count = citations.length - mid;
            if(count == citations[mid]){
                return count;
            }else if(count < citations[mid]){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(citations[start] >= citations.length - start){
            return citations.length - start;
        }
        if(citations[end] >= citations.length - end){
            return citations.length - end;
        }
        return 0;

    }
}
