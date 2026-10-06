class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2L * n + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int i = 0; i < n; i++) {
            actualSum += arr[i];
            actualSquareSum += (long) arr[i] * arr[i];
        }

        // repeating - missing
        long diff = actualSum - expectedSum;

        // repeating^2 - missing^2
        long squareDiff = actualSquareSum - expectedSquareSum;

        // repeating + missing
        long sum = squareDiff / diff;

        int repeating = (int) ((diff + sum) / 2);
        int missing = (int) ((sum - diff) / 2);

        ArrayList<Integer> result = new ArrayList<>();

        // Required order: repeating, missing
        result.add(repeating);
        result.add(missing);

        return result;
    }
}