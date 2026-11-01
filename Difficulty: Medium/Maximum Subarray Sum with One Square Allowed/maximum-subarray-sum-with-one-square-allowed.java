class Solution {
    public int maximumSubarray(int[] arr) {
                int n = arr.length;

                int noSquare = arr[0];
                int oneSquare = arr[0] * arr[0];

                int maxSum = Math.max(noSquare, oneSquare);

                for (int i = 1; i < n; i++) {

                    int x = arr[i];

                    int newOneSquare = Math.max(
                        oneSquare + x,
                        Math.max(noSquare + x * x, x * x)
                    );

                    int newNoSquare = Math.max(
                        noSquare + x,
                        x
                    );

    noSquare = newNoSquare;
  oneSquare = newOneSquare;

                    maxSum = Math.max(maxSum, Math.max(noSquare, oneSquare));
                }

                return maxSum;
    }
}