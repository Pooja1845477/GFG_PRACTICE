class Solution {
    public int subarrayXor(int[] arr) {
        int n = arr.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if ((i + 1) % 2 == 1 && (n - i) % 2 == 1) {
                ans ^= arr[i];
            }
        }

        return ans;
    }
}