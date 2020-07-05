package Dynamic_programming;

import java.util.List;

public class M_120Triangle {
    //solution1 traverse(over time)
    private int min = Integer.MAX_VALUE;
    public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        traverse(triangle, 0, 0, 0);
        return min;
    }

    private void traverse(List<List<Integer>> triangle, int x, int y, int sum){
        if(x >= triangle.size()){
            min = Math.min(min, sum);
            return;
        }

        traverse(triangle, x + 1, y, sum + triangle.get(x).get(y));
        traverse(triangle, x + 1, y + 1, sum + triangle.get(x).get(y));
    }

    //solution2 divided and conquer(over time)
    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int x, int y){
        if(x == triangle.size() - 1){

            return triangle.get(x).get(y);
        }
        int left = dfs(triangle, x + 1, y);
        int right = dfs(triangle, x + 1, y + 1);

        return Math.min(left, right) + triangle.get(x).get(y);
    }

    //solution3 + hash
    public int minimumTotal3(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int n = triangle.size();
        int[][] hash = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < triangle.get(i).size();j++){
                hash[i][j] = Integer.MAX_VALUE;
            }
        }
        return dfs(triangle, hash, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int[][]hash, int x, int y){
        if(x == triangle.size() - 1){

            return triangle.get(x).get(y);
        }
        if(hash[x][y] != Integer.MAX_VALUE){
            return hash[x][y];
        }
        int left = dfs(triangle, hash, x + 1, y);
        int right = dfs(triangle, hash, x + 1, y + 1);

        hash[x][y] = Math.min(left, right) + triangle.get(x).get(y);
        return hash[x][y];
    }

    //solution4 top to down
    public int minimumTotal4(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < n; i ++){
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        for(int i = 1; i < n; i ++){
            for(int j = 1; j < i; j ++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }
        int best = dp[n - 1][0];
        for(int i = 1; i < n; i ++){
            best = Math.min(best, dp[n - 1][i]);
        }
        return best;
    }
}
