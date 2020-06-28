package binarySearch;

public class M_528RandomPickWithWeight {
    int[] array;
    int sum = 0;
    public void Solution(int[] w) {
        array = new int[w.length];
        for(int i = 0; i < w.length; i ++){

            sum = w[i] + sum;
            array[i] = sum;
        }
    }

    public int pickIndex() {
        if(array.length == 0){
            return -1;
        }
        if(array.length == 1){
            return 0;
        }
        int index = (int)(sum * Math.random()) + 1;
        int start = 0;
        int end = array.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(array[mid] > index){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(index <= array[end] && index > array[start]){
            return end;
        }else{
            return start;
        }

    }
}
