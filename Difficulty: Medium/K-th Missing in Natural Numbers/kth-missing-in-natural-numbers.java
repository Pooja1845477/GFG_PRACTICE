class Solution {
    public int findKthSmall(int[] arr, int k) {

                Arrays.sort(arr);

                int prev = 0;

                for (int i = 0; i < arr.length; i++) {

                    int missing = arr[i] - prev - 1;

                    if (k <= missing) {
                        return prev + k;
                    }

                    k = k - missing;
                    prev = arr[i];
                }

                return prev + k;
    }
}