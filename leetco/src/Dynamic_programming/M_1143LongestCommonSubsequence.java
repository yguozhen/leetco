package Dynamic_programming;

public class M_1143LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int a = text1.length();
        int b = text2.length();
        int[][] dp = new int[a + 1][b + 1];

        for(int i = 1; i <= a; i ++){
            for(int j = 1; j <= b; j ++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[a][b];
    }
}
