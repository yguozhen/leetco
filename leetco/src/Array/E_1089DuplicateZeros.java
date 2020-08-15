package Array;

import java.util.LinkedList;
import java.util.Queue;

public class E_1089DuplicateZeros {
    //solution1 queue
    public void duplicateZeros1(int[] arr) {
        if(arr == null || arr.length == 0){
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            if(queue.isEmpty()){
                if(arr[i] == 0){
                    queue.offer(0);
                }
            }else{
                queue.offer(arr[i]);
                if(arr[i] == 0){
                    queue.offer(arr[i]);
                }
                arr[i] = queue.poll();
            }
        }
    }
    //solution2 count zeros
    public void duplicateZeros2(int[] arr) {
        if(arr == null || arr.length == 0){
            return;
        }
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                count++;
            }
        }
        for(int i = arr.length - 1, j = arr.length + count - 1; i >= 0; i--, j--){
            if(arr[i] == 0){
                if(j < arr.length) arr[j] = arr[i];
                j--;
                if(j < arr.length) arr[j] = arr[i];
            }else{
                if(j < arr.length){
                    arr[j] = arr[i];
                }
            }
        }
    }
}
