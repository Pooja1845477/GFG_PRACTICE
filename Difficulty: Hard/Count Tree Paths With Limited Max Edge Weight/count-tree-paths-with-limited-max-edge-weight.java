import java.util.*;

class Solution {

    static class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        long union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV) {
                return 0;
            }

            long paths = (long) size[rootU] * size[rootV];

            if (size[rootU] < size[rootV]) {
                int temp = rootU;
                rootU = rootV;
                rootV = temp;
            }

            parent[rootV] = rootU;
            size[rootU] += size[rootV];

            return paths;
        }
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int q = queries.length;

        int[][] sortedQueries = new int[q][2];

        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries,
                (a, b) -> Integer.compare(a[0], b[0]));

        long[] ans = new long[q];

        DSU dsu = new DSU(n);

        long count = 0;
        int edgeIndex = 0;

        for (int i = 0; i < q; i++) {

            int limit = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];

            while (edgeIndex < edges.length &&
                   edges[edgeIndex][2] <= limit) {

                int u = edges[edgeIndex][0];
                int v = edges[edgeIndex][1];

                count += dsu.union(u, v);

                edgeIndex++;
            }

            ans[originalIndex] = count;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            result.add((int) ans[i]);
        }

        return result;
    }
}