class Solution {
    public int minimumSum(String s) {
        int n = s.length();
        int m = (n + 1) / 2;

        char[] a = new char[m];

        for (int i = 0; i < m; i++) {
            char left = s.charAt(i);
            char right = s.charAt(n - 1 - i);

            if (left != '?' && right != '?' && left != right) {
                return -1;
            }

            if (left != '?') {
                a[i] = left;
            } else if (right != '?') {
                a[i] = right;
            } else {
                a[i] = '?';
            }
        }

        int INF = 1000000000;
        int[] dp = new int[26];
        int[] next = new int[26];

        for (int c = 0; c < 26; c++) {
            if (a[0] == '?' || a[0] == (char) ('a' + c)) {
                dp[c] = 0;
            } else {
                dp[c] = INF;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int c = 0; c < 26; c++) {
                next[c] = INF;

                if (a[i] != '?' && a[i] != (char) ('a' + c)) {
                    continue;
                }

                for (int p = 0; p < 26; p++) {
                    int cost = Math.abs(c - p);

                    if (dp[p] != INF) {
                        next[c] = Math.min(next[c], dp[p] + cost);
                    }
                }
            }

            int[] temp = dp;
            dp = next;
            next = temp;
        }

        int ans = INF;

        for (int c = 0; c < 26; c++) {
            ans = Math.min(ans, dp[c]);
        }

        return ans * 2 - (n % 2 == 1 ? 0 : 0);
    }
}