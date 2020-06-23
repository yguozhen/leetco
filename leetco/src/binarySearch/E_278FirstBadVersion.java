package binarySearch;

public class E_278FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 0;
        int end = n;

        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(isBadVersion(start)){
            return start;
        }else{
            return end;
        }
    }
}
