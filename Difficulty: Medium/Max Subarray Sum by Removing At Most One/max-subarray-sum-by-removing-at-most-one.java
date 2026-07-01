class Solution {
    public int maxSumSubarray(int[] arr) {
        // code here

        long keep = arr[0];
        long remove = Long.MIN_VALUE / 2;

        long ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            long newKeep = Math.max(arr[i], keep + arr[i]);
            long newRemove = Math.max(keep, remove + arr[i]);

            keep = newKeep;
            remove = newRemove;

            ans = Math.max(ans, Math.max(keep, remove));
        }

        return (int) ans;
    }
}