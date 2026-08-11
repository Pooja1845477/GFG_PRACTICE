class Solution {
    static int closestNumber(int n, int m) {

        int q = n / m;

        int lower = q * m;
        int upper;

        if (n * m > 0)
            upper = (q + 1) * m;
        else
            upper = (q - 1) * m;

        int d1 = Math.abs(n - lower);
        int d2 = Math.abs(n - upper);

        if (d1 < d2)
            return lower;
        else if (d2 < d1)
            return upper;
        else
            return Math.max(Math.abs(lower), Math.abs(upper)) == Math.abs(lower)
                    ? lower : upper;
    }
}