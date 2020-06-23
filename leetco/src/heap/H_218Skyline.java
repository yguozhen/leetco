package heap;

public class H_218Skyline {
    //solution1
    /**
     *
     *   buildings : [2 9 10],[3 7 15],[5 12 12],[15 20 10],[19 24 8]
     *   heights :  [2 -10][3 -15][5 -12][7 15][9 10][12 12][15 -10][19 -8][20 10][24 8]
     *   map   15 : 1 ×
     *         12 : 1 ×
     *         10 : 1 ×
     *         8  : 1 ×
     *         0  : 1
     *   prev :  8
     * 起点是负数
     * @param buildings
     * @return
     *
     * Time O(n^2)
     * Space O(n)
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }

        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder()); //逆序排列
        map.put(0, 1);
        int prev = 0;
        for (int[] h : heights) {
            if (h[1] < 0) {
                map.put(-h[1], map.getOrDefault(-h[1], 0) + 1);
            } else {
                int cnt = map.get(h[1]);
                if (cnt == 1) {
                    map.remove(h[1]);
                } else {
                    map.put(h[1], cnt - 1);
                }
            }
            int cur = map.firstKey();
            if (prev != cur) {
                List<Integer> list = new ArrayList<>();
                list.add(h[0]);
                list.add(cur);
                res.add(list);
                prev = cur;
            }
        }
        return res;
    }

    //solution2

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        int numOfBuildings = buildings.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return b[2]-a[2];
            }
        });

        int x = numOfBuildings==0?Integer.MAX_VALUE:buildings[0][0];
        int next=0;
        pq.offer(new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,0});

        while(x!=Integer.MAX_VALUE || next<numOfBuildings || pq.size()>1){

            while(pq.size()>1 && pq.peek()[1]<=x){

                pq.poll();
            }


            while(next<numOfBuildings && x==buildings[next][0])                                             pq.offer(buildings[next++]);


            if(ans.size()==0 || pq.peek()[2]!=ans.get(ans.size()-1).get(1))
                ans.add(Arrays.asList(new Integer[]{x,pq.peek()[2]}));


            x = Math.min(pq.peek()[1],next>=numOfBuildings?                 Integer.MAX_VALUE:buildings[next][0]);
        }

        return ans;
    }
}
