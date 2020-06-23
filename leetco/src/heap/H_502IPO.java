package heap;

public class H_502IPO {
    //solution 1 o(kn)
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

        if(k == 0) return W;
        int leng = Capital.length;

        for(int i = 0; i < k; i++){
            W = helper(Profits,Capital, W) + W;
        }
        return W;
    }
    public int helper(int[] pure, int[] Capital, int W){
        int max = -1;
        int dele = -1;

        for(int i = 0; i < pure.length; i ++){
            if(W < Capital[i]) continue;
            if(pure[i] > max){
                max = pure[i];
                dele = i;
            }

        }
        if(dele != -1)pure[dele] = 0;
        if(max == -1) return 0;
        return max;
    }

    //solution2 o()klogn
    PriorityQueue<int[]> cap = new PriorityQueue<>((a, b) -> (a[0] - b[0])); //按本金从小到大
    PriorityQueue<int[]> pro = new PriorityQueue<>((a, b) -> (b[1] - a[1])); //按利润从大到小

        for (int i = 0; i < Profits.length; i++) {
        cap.add(new int[]{Capital[i], Profits[i]});
    }

        for (int i = 0; i < k; i++) {
        while (!cap.isEmpty() && cap.peek()[0] <= W) {
            pro.add(cap.poll());
        }
        if (pro.isEmpty()) {
            break;
        }
        W += pro.poll()[1];
    }
        return W;
}
}
