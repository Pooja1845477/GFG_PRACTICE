class Solution {
    int maxLength(int arr[]) {
        // code here

        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 exists before the array starts
        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (map.containsKey(sum)) {

                // Same prefix sum found
                int length = i - map.get(sum);

                maxLength = Math.max(maxLength, length);

            } else {

                // Store only the first occurrence
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}