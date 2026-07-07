class Solution {
    public int largestArea(int n, int m, int[][] arr) {
    //code
        int k = arr.length;

        if (k == 0)
            return n * m;

        int[] rows = new int[k];
        int[] cols = new int[k];

        for (int i = 0; i < k; i++) {
            rows[i] = arr[i][0];
            cols[i] = arr[i][1];
        }

        Arrays.sort(rows);
        Arrays.sort(cols);

        int maxRows = rows[0] - 1;

        for (int i = 1; i < k; i++) {
            maxRows = Math.max(maxRows, rows[i] - rows[i - 1] - 1);
        }

        maxRows = Math.max(maxRows, n - rows[k - 1]);

        int maxCols = cols[0] - 1;

        for (int i = 1; i < k; i++) {
            maxCols = Math.max(maxCols, cols[i] - cols[i - 1] - 1);
        }

        maxCols = Math.max(maxCols, m - cols[k - 1]);

        return maxRows * maxCols;
    }
}