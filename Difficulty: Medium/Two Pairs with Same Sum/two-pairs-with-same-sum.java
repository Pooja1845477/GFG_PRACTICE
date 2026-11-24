class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {


        int n = arr.length;

        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

        // Generate all pairs
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int sum = arr[i] + arr[j];

                map.putIfAbsent(sum, new ArrayList<>());

                map.get(sum).add(new int[]{i, j});
            }
        }

        // Check pairs in lexicographical order
        for (int a = 0; a < n; a++) {

            for (int b = a + 1; b < n; b++) {

                int sum = arr[a] + arr[b];

                ArrayList<int[]> pairs = map.get(sum);

                for (int[] pair : pairs) {

                    int c = pair[0];
                    int d = pair[1];

                    // All four indices must be distinct
                    if (a != c && a != d &&
                        b != c && b != d) {

                        // Ensure first pair is lexicographically smaller
                        if (a < c || (a == c && b < d)) {

                            ArrayList<Integer> result = new ArrayList<>();

                            result.add(a);
                            result.add(b);
                            result.add(c);
                            result.add(d);

                            return result;
                        }
                    }
                }
            }
        }

        return new ArrayList<>(Arrays.asList(-1, -1, -1, -1));
    }

    }