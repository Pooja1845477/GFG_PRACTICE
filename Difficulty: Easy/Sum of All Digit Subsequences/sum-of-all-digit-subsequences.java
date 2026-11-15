class Solution {
    public int subsequenceSum(String s) {

                long MOD = 1000000007;
                int n = s.length();

                long sum = 0;

                // Calculate sum of all digits
                for (int i = 0; i < n; i++) {
                    sum += s.charAt(i) - '0';
                }

                // Calculate 2^(n-1) using modular exponentiation
                long power = 1;
                long base = 2;
                int exp = n - 1;

                while (exp > 0) {
                    if (exp % 2 == 1) {
                        power = (power * base) % MOD;
                    }

                    base = (base * base) % MOD;
                    exp /= 2;
                }

                long ans = (sum * power) % MOD;

                return (int) ans;
    }
}