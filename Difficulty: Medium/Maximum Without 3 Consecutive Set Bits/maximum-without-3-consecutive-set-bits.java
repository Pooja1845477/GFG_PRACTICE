class Solution {
    public int maxValue(int n) {
        // code here
        while ((n & (n >> 1) & (n >> 2)) != 0) {
                    int x = n & (n >> 1) & (n >> 2);
                    int bit = Integer.highestOneBit(x);
                    n &= ~(bit >> 0);
                }
                return n;
    }
}