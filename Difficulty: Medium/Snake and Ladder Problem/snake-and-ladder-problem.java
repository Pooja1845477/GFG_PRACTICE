class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        // code here
         int N = n * n;

         // jump[i] = destination if there is a snake/ladder at i
         int[] jump = new int[N + 1];

         for (int i = 1; i <= N; i++) {
             jump[i] = i;
         }

         // Ladders
         for (int i = 0; i < lad.length; i += 2) {
             jump[lad[i]] = lad[i + 1];
         }

         // Snakes
         for (int i = 0; i < sn.length; i += 2) {
             jump[sn[i]] = sn[i + 1];
         }

         boolean[] visited = new boolean[N + 1];

         // Queue stores {cell, number of throws}
         java.util.Queue<int[]> q = new java.util.LinkedList<>();

         q.offer(new int[]{1, 0});
         visited[1] = true;

         while (!q.isEmpty()) {
             int[] current = q.poll();

             int cell = current[0];
             int throwsCount = current[1];

             if (cell == N) {
                 return throwsCount;
             }

             // Try all possible dice outcomes: 1 to 6
             for (int dice = 1; dice <= 6; dice++) {
                 int next = cell + dice;

                 if (next > N) {
                     break;
                 }

                 // Take snake or ladder immediately
                 next = jump[next];

                 if (!visited[next]) {
                     visited[next] = true;
                     q.offer(new int[]{next, throwsCount + 1});
                 }
             }
         }

         return -1;
     }
 }