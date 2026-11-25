class Solution {

    static final long MOD = 1000000007L;

    // Time required to reach position x using normal movement
    static long normalTime(long x, long a, long b) {

        if (x <= a) {
            return x;
        }

        long p = a - b;

        long k = (x - a + p - 1) / p;

        return x + 2 * b * k;
    }

    // Time required using special jump
    static long jumpTime(long x, long a, long b) {
        return normalTime(x, a, b) + 1;
    }

    // Sum of ceil(i / p) from i = 1 to n
    static long prefixCeil(long n, long p) {

        if (n <= 0) {
            return 0;
        }

        long m = n / p;
        long s = n % p;

        return p * m * (m + 1) / 2
                + s * (m + 1);
    }

    // Sum of jump times for positions L to R
    static long sumJump(long L, long R,
                        long a, long b) {

        if (L > R) {
            return 0;
        }

        long ans = 0;

        // Case 1: x <= a
        long left = L;
        long right = Math.min(R, a);

        if (left <= right) {

            long count = right - left + 1;

            long sumX = (left + right) * count / 2;

            ans += sumX + count;
        }

        // Case 2: x > a
        left = Math.max(L, a + 1);
        right = R;

        if (left <= right) {

            long count = right - left + 1;

            long sumX = (left + right) * count / 2;

            long p = a - b;

            long ceilSum =
                    prefixCeil(right - a, p)
                    - prefixCeil(left - a - 1, p);

            ans += sumX + count + 2 * b * ceilSum;
        }

        return ans;
    }

    public int minTime(int a, int b, int d, int l, int r) {

        long A = a;
        long B = b;
        long D = d;

        // Time without using special jump
        long normal = normalTime(D, A, B);

        // Convert jump lengths into required positions
        long L = D - r;
        long R = D - l;

        // Binary search for largest position
        // where special jump is better
        long low = L;
        long high = R;

        long cutoff = L - 1;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (jumpTime(mid, A, B) < normal) {

                cutoff = mid;
                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        // Positions where special jump is optimal
        long jumpRight = Math.min(R, cutoff);

        long ans = sumJump(L, jumpRight, A, B);

        // Remaining positions use normal movement
        long normalLeft = Math.max(L, cutoff + 1);

        if (normalLeft <= R) {

            long count = R - normalLeft + 1;

            ans += count * normal;
        }

        return (int) (ans % MOD);
    }
}