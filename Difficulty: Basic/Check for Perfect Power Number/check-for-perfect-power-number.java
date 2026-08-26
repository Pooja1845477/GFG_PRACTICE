class Solution {
    public boolean checkPower(int n) {

          // 1 = 1^y, where y > 1
          if (n == 1)
              return true;

          for (int x = 2; x * x <= n; x++) {
              int power = x * x;

              while (power <= n) {

                  if (power == n)
                      return true;

                  // Prevent integer overflow
                  if (power > n / x)
                      break;

                  power *= x;
              }
          }

          return false;
      }
  }