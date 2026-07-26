class Solution {
    public int maximumSum(int[][] mat, int k) {
        int n = mat.length;
        int[] temp = new int[n];
        // First k-row sums for each column
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < k; i++) {
                temp[j] += mat[i][j];
            }
        }
        int max = Integer.MIN_VALUE;

        for (int top = 0; top <= n - k; top++) {

            // Sum of first k columns
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += temp[j];
            }

            max = Math.max(max, sum);

            // Slide horizontally
            for (int j = k; j < n; j++) {
                sum += temp[j] - temp[j - k];
                max = Math.max(max, sum);
            }

            // Slide row window downward
            if (top < n - k) {
                for (int j = 0; j < n; j++) {
                    temp[j] += mat[top + k][j] - mat[top][j];
                }
            }
        }

        return max;
    }
}