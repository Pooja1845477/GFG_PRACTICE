class Solution {
    public int getCount(int n) {

         int count = 0;

        for (int k = 2; k * (k + 1) / 2 <= n; k++) {

            int temp = n - (k * (k - 1)) / 2;

            if (temp > 0 && temp % k == 0) {
                count++;
            }
        }

        return count;
    }
}
