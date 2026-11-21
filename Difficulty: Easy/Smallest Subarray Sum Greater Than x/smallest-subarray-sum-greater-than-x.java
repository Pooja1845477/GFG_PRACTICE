class Solution {
    public int smallestSubWithSum(int[] arr, int x) {

                int left = 0;
                int sum = 0;
                int minLength = Integer.MAX_VALUE;

                for (int right = 0; right < arr.length; right++) {

                    sum += arr[right];

                    while (sum > x) {

                        int length = right - left + 1;

                        minLength = Math.min(minLength, length);

                        sum -= arr[left];
                        left++;
                    }
                }

                if (minLength == Integer.MAX_VALUE) {
                    return 0;
                }

                return minLength;
            
    }
}