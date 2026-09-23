class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;

        int left[] = new int[n];
        int right[] = new int[n];

        // Maximum possible height from left
        left[0] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = Math.min(arr[i], left[i - 1] + 1);
        }

        // Maximum possible height from right
        right[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }

        /*
         * Find the best pyramid.
         *
         * For each position, the maximum height that can be
         * used as the peak is min(left[i], right[i]).
         *
         * We calculate the maximum number of stones that can
         * be kept in a valid pyramid.
         */
        long total = 0;

        for (int i = 0; i < n; i++) {
            total += arr[i];
        }

        long maxKeep = 0;

        for (int i = 0; i < n; i++) {
            int h = Math.min(left[i], right[i]);

            long keep = 0;

            // Left side including peak
            int start = i - h + 1;

            if (start < 0) {
                start = 0;
            }

            int actualH = i - start + 1;

            keep += (long) actualH * (actualH + 1) / 2;

            // Right side
            int rightH = Math.min(h - 1, n - i - 1);

            keep += (long) rightH * (rightH + 1) / 2;

            maxKeep = Math.max(maxKeep, keep);
        }

        return (int)(total - maxKeep);
    }
}