class Solution {
     public boolean isNegativeWeightCycle(int V, int[][] edges) {

         int[] dist = new int[V];

         // Initialize all distances to 0
         // so that cycles in any component can be detected
         for (int i = 0; i < V; i++) {
             dist[i] = 0;
         }

         // Relax edges V times
         for (int i = 0; i < V; i++) {
             boolean updated = false;

             for (int[] edge : edges) {
                 int u = edge[0];
                 int v = edge[1];
                 int w = edge[2];

                 if (dist[u] + w < dist[v]) {
                     dist[v] = dist[u] + w;
                     updated = true;

                     // Update on Vth iteration => negative cycle
                     if (i == V - 1) {
                         return true;
                     }
                 }
             }

             // No update means no negative cycle
             if (!updated) {
                 return false;
             }
         }

         return false;
     }
 }