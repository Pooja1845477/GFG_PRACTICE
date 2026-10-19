class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int count = 0;
        int[] state = new int[n];

        for (int i = 0; i < n; i++) {
            if (state[i] == 0) {
                java.util.ArrayList<Integer> path = new java.util.ArrayList<>();
                int curr = i;

                while (curr >= 0 && curr < n
                        && state[curr] == 0 && arr[curr] != 0) {
                    path.add(curr);
                    state[curr] = 2;
                    curr += arr[curr];
                }

                int result;

                if (curr < 0 || curr >= n) {
                    result = 1;
                } else if (arr[curr] == 0 || state[curr] == 2) {
                    result = -1;
                } else {
                    result = state[curr];
                }

                for (int index : path) {
                    state[index] = result;
                }
            }

            if (state[i] == 1) {
                count++;
            }
        }

        return count;
    }
}