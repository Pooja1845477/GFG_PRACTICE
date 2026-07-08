class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int countCoordinates(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] p = new boolean[n][m];
        boolean[][] q = new boolean[n][m];

        // Station P (Top row)
        for (int j = 0; j < m; j++)
            dfs(mat, 0, j, p);

        // Station P (Left column)
        for (int i = 0; i < n; i++)
            dfs(mat, i, 0, p);

        // Station Q (Bottom row)
        for (int j = 0; j < m; j++)
            dfs(mat, n - 1, j, q);

        // Station Q (Right column)
        for (int i = 0; i < n; i++)
            dfs(mat, i, m - 1, q);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && q[i][j])
                    ans++;
            }
        }

        return ans;
    }

    void dfs(int[][] mat, int r, int c, boolean[][] vis) {

        if (vis[r][c])
            return;

        vis[r][c] = true;

        int n = mat.length;
        int m = mat[0].length;

        for (int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m
                    && !vis[nr][nc]
                    && mat[nr][nc] >= mat[r][c]) {

                dfs(mat, nr, nc, vis);
            }
        }
    }
}