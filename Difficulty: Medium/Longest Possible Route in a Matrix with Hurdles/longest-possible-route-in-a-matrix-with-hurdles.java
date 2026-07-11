class Solution {
        int max = -1;
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        // code here
   


    

        int n = mat.length;
        int m = mat[0].length;

        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;

        boolean[][] vis = new boolean[n][m];

        dfs(mat, xs, ys, xd, yd, vis, 0);

        return max;
    }

    void dfs(int[][] mat, int x, int y, int xd, int yd,
             boolean[][] vis, int len) {

        if (x == xd && y == yd) {
            max = Math.max(max, len);
            return;
        }

        vis[x][y] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {

            int nr = x + dr[i];
            int nc = y + dc[i];

            if (nr >= 0 && nr < mat.length &&
                nc >= 0 && nc < mat[0].length &&
                mat[nr][nc] == 1 &&
                !vis[nr][nc]) {

                dfs(mat, nr, nc, xd, yd, vis, len + 1);
            }
        }

        vis[x][y] = false;
    }
}
