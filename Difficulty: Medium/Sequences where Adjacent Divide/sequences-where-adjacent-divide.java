class Solution {
    public int count(int n, int m) {
        // code here
         int[][] dp = new int[n + 1][m + 1];

        // Base case
        for (int j = 1; j <= m; j++) {
            dp[1][j] = 1;
        }

        // Build DP
        for (int len = 2; len <= n; len++) {

            for (int last = 1; last <= m; last++) {

                for (int prev = 1; prev <= m; prev++) {

                    if (last % prev == 0 || prev % last == 0) {
                        dp[len][last] += dp[len - 1][prev];
                    }
                }
            }
        }
        int ans = 0;

        for (int j = 1; j <= m; j++)
            ans += dp[n][j];

        return ans;
    }
}