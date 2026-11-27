class Solution {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {
        int count = 0;
        int V = adj.size();

        for (int i = 0; i < V; i++) {
            count += adj.get(i).size();
        }

        return count / 2;
    }
}