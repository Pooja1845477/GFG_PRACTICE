import java.util.*;

class Solution {

    boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        vis[node] = true;

        for (int neigh : adj.get(node)) {

            if (!vis[neigh]) {

                if (dfs(neigh, node, adj, vis))
                    return true;

            } else if (neigh != parent) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {

                if (dfs(i, -1, adj, vis))
                    return true;
            }
        }

        return false;
    }
}