package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class M_253MeetingRoom2 {
    //solution1 treemap
    //
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        TreeMap<Integer, Integer> temp = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            temp.put(start, temp.getOrDefault(start, 0) + 1);
            temp.put(end, temp.getOrDefault(end, 0) - 1);
        }
        int result = 0;
        int cur = 0;
        for(int key : temp.keySet()){
            cur = cur + temp.get(key);
            result = Math.max(result, cur);
        }
        return result;
    }

    //solution2 pq + sort(Comparator)
    public int minMeetingRooms2(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }else{
                    return a[0] - b[0];
                }
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            if(pq.peek() <= intervals[i][0]){
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}
