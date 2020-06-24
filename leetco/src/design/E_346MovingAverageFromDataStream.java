package design;

import java.util.ArrayList;
    //solution1 O(1)
    public class E_346MovingAverageFromDataStream {
        ArrayList<Integer> list = new ArrayList<>();
        double temp = 0;
        int m = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            m = size;
        }

        public double next(int val) {
            list.add(val);
            if (list.size() <= m) {
                temp = temp + val;
                return temp / list.size();
            } else {
                temp = temp + val;
                temp = temp - list.get(list.size() - 1 - m);
                return temp / m;
            }

        }

    }

    //solution2 o(m)
    ArrayList<Integer> list = new ArrayList<>();
    int m = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        m = size;
    }

    public double next(int val) {
        list.add(val);
        double sum = 0;
        if(list.size() < m){
            for(double number :list){
                sum = sum + number;
            }
            return sum/list.size();
        }else{
            for(int i = 0; i < m; i ++){
                sum = sum + list.get(list.size() - 1 - i);
            }
            return sum / m;
        }
    }
}
