class Solution {
    public int rightmostNonZeroDigit(int[] arr) {
                long product = 1;

                for (int num : arr) {

                    if (num == 0) {
                        return -1;
                    }

                    product *= num;

                    // Remove trailing zeros
                    while (product % 10 == 0) {
                        product /= 10;
                    }

                    // Keep the number small
                    product %= 1000000000;
                }

                return (int)(product % 10);
            }
        }
    