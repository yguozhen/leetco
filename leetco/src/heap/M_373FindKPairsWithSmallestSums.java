package heap;

public class M_373FindKPairsWithSmallestSums {
    //solution1 pq
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> list = new PriorityQueue<List<Integer>>((a,b) -> a.get(0) + a.get(1) - b.get(0) - b.get(1));
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums1.length == 0 || nums2.length == 0) return result;
        for(int i = 0; i < nums1.length; i++){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(nums1[i]);
            temp.add(nums2[0]);
            temp.add(0);
            list.add(temp);
        }

        while(!list.isEmpty() && result.size() < k){
            List<Integer> temp = list.poll();
            List<Integer> individual = new ArrayList<Integer>();
            individual.add(temp.get(0));
            individual.add(temp.get(1));
            result.add(individual);

            if(temp.get(2) + 1 == nums2.length) continue;
            List<Integer> repl = new ArrayList<Integer>();
            repl.add(temp.get(0));
            repl.add(nums2[temp.get(2) + 1]);
            repl.add(temp.get(2) + 1);
            list.add(repl);

        }
        return result;

    }
}
