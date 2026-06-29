class Solution {

    int[][] dp;

    int solve(int[] a, int[] b, int i, int j) {

        if (j == b.length)
            return 0;

        if (i == a.length)
            return Integer.MIN_VALUE;

        if (dp[i][j] != -1)
            return dp[i][j];

        int take = a[i] * b[j] + solve(a, b, i + 1, j + 1);

        int skip = solve(a, b, i + 1, j);

        return dp[i][j] = Math.max(take, skip);
    }

    public int maxDotProduct(int[] a, int[] b) {

        dp = new int[a.length][b.length];

        for (int i = 0; i < a.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(a, b, 0, 0);
    }
}