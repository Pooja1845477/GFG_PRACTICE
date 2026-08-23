import java.util.*;

 class Solution {
     public int numberOfCells(int r, int c, int u, int d, char[][] mat) {

         int n = mat.length;
         int m = mat[0].length;

         if (mat[r][c] == '#')
             return 0;

         // {up moves, down moves, row, col}
         PriorityQueue<int[]> pq = new PriorityQueue<>(
             (a, b) -> {
                 if (a[0] != b[0])
                     return a[0] - b[0];
                 return a[1] - b[1];
             }
         );

         boolean[][] visited = new boolean[n][m];

         pq.add(new int[]{0, 0, r, c});
         visited[r][c] = true;

         int[] dr = {-1, 1, 0, 0};
         int[] dc = {0, 0, -1, 1};

         while (!pq.isEmpty()) {

             int[] cur = pq.poll();

             int up = cur[0];
             int down = cur[1];
             int x = cur[2];
             int y = cur[3];

             for (int k = 0; k < 4; k++) {

                 int nx = x + dr[k];
                 int ny = y + dc[k];

                 if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                     continue;

                 if (mat[nx][ny] == '#' || visited[nx][ny])
                     continue;

                 int newUp = up;
                 int newDown = down;

                 if (nx < x) {
                     newUp++;
                 } 
                 else if (nx > x) {
                     newDown++;
                 }

                 if (newUp > u || newDown > d)
                     continue;

                 visited[nx][ny] = true;

                 pq.add(new int[]{
                     newUp, newDown, nx, ny
                 });
             }
         }

         int count = 0;

         for (int i = 0; i < n; i++) {
             for (int j = 0; j < m; j++) {
                 if (visited[i][j])
                     count++;
             }
         }

         return count;
     }
 }