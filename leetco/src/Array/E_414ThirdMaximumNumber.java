package Array;

import java.util.HashSet;
import java.util.PriorityQueue;

public class E_414ThirdMaximumNumber {
    //solution1 3 character to determine
    public int thirdMax1(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;
        for(Integer num:nums){
            if(num.equals(first)|| num.equals(second) || num.equals(third)){
                continue;
            }else if(first == null || num > first){
                third = second;
                second = first;
                first = num;
            }else if(second == null || num > second){
                third = second;
                second = num;
            }else if(third == null || num > third){
                third = num;
            }
        }
        return third == null?first:third;
    }

    //solution2 priority queue and hashset
    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.add(num)){
                pq.offer(num);
                if(pq.size() > 3){
                    pq.poll();
                }
            }
        }
        if(pq.size() == 2){
            pq.poll();
        }
        return pq.peek();
    }

}
