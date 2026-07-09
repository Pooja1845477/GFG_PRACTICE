class Solution {
    public int countKdivPairs(int[] arr, int k) {
        // code here
        int freq[] = new int[k];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            int rem = arr[i] % k;

            int complement = (k - rem) % k;

            count += freq[complement];

            freq[rem]++;
        }

        return count;
    }
}