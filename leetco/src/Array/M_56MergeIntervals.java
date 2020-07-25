package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class M_56MergeIntervals {

    //solution1 sort the intervals and create list to store and list to int[][]
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {

            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        if(intervals == null || intervals.length == 0){
            return intervals;
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(intervals[0][0]);
        list.add(temp);
        int curmax = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(curmax < intervals[i][0]){
                list.get(list.size() - 1).add(curmax);
                List<Integer> cur = new ArrayList<>();
                cur.add(intervals[i][0]);
                list.add(cur);
                curmax = intervals[i][1];
            }else if(curmax == intervals[i][0]){
                curmax = intervals[i][1];
            }else if(curmax > intervals[i][0]){
                if(curmax >= intervals[i][1]){
                    continue;
                }
                curmax = intervals[i][1];
            }
        }
        list.get(list.size() - 1).add(curmax);
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < 2; j++){
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }
}
