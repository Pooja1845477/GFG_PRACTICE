class Solution {
    int minEdgesReq(int n, int[][] edges) {
        // code here

        int m = edges.length;

        // Not enough edges to connect n vertices
        if (m < n - 1) {
            return -1;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        int components = 0;

        // Count connected components
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                components++;
                dfs(i, graph, visited);
            }
        }

        return components - 1;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    
    }
}