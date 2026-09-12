class Solution {
    public int maxProduct(int[] arr, int k) {
        // code her

        long[] maxDp = new long[k + 1];
        long[] minDp = new long[k + 1];

        for (int i = 0; i <= k; i++) {
            maxDp[i] = Long.MIN_VALUE;
            minDp[i] = Long.MAX_VALUE;
        }

        maxDp[0] = 1;
        minDp[0] = 1;

        for (int x : arr) {
            for (int j = k; j >= 1; j--) {

                if (maxDp[j - 1] != Long.MIN_VALUE) {
                    long p1 = maxDp[j - 1] * x;
                    long p2 = minDp[j - 1] * x;

                    maxDp[j] = Math.max(maxDp[j], Math.max(p1, p2));
                    minDp[j] = Math.min(minDp[j], Math.min(p1, p2));
                }
            }
        }

        return (int) maxDp[k];
    }
}