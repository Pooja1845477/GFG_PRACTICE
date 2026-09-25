class Solution {
    public int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;

        // 3 rotations for every box
        int[][] box = new int[3 * n][3];

        int k = 0;

        for (int i = 0; i < n; i++) {

            // height = height[i]
            box[k][0] = height[i];
            box[k][1] = Math.min(width[i], length[i]);
            box[k][2] = Math.max(width[i], length[i]);
            k++;

            // height = width[i]
            box[k][0] = width[i];
            box[k][1] = Math.min(height[i], length[i]);
            box[k][2] = Math.max(height[i], length[i]);
            k++;

            // height = length[i]
            box[k][0] = length[i];
            box[k][1] = Math.min(height[i], width[i]);
            box[k][2] = Math.max(height[i], width[i]);
            k++;
        }

        // Sort by base area in decreasing order
        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k; j++) {

                long area1 = (long) box[i][1] * box[i][2];
                long area2 = (long) box[j][1] * box[j][2];

                if (area1 < area2) {
                    int[] temp = box[i];
                    box[i] = box[j];
                    box[j] = temp;
                }
            }
        }

        int dp[] = new int[k];

        int ans = 0;

        for (int i = 0; i < k; i++) {

            dp[i] = box[i][0];

            for (int j = 0; j < i; j++) {

                // box[j] is below box[i]
                if (box[j][1] > box[i][1] &&
                    box[j][2] > box[i][2]) {

                    dp[i] = Math.max(
                        dp[i],
                        dp[j] + box[i][0]
                    );
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}