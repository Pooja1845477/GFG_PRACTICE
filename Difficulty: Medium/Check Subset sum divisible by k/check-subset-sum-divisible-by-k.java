class Solution {
    public boolean divisibleByK(int[] arr, int k) {
      
        boolean[] dp = new boolean[k];

        for (int x : arr) {

            boolean[] next = dp.clone();

            next[x % k] = true;

            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    next[(r + x) % k] = true;
                }
            }

            dp = next;

            if (dp[0]) {
                return true;
            }
        }

        return false;
    }
}