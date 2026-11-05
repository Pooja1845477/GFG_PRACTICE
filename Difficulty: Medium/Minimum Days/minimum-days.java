class Solution {
    public int getMinimumDays(String s, int[] p) {
               int n = s.length();

               if (check(s, p, 0)) {
                   return 0;
               }

               int low = 1;
               int high = n;
               int ans = n;

               while (low <= high) {
                   int mid = low + (high - low) / 2;

                   if (check(s, p, mid)) {
                       ans = mid;
                       high = mid - 1;
                   } else {
                       low = mid + 1;
                   }
               }

               return ans;
           }

           public boolean check(String s, int[] p, int days) {
               int n = s.length();
               boolean[] replaced = new boolean[n];

               for (int i = 0; i < days; i++) {
                   replaced[p[i]] = true;
               }

               for (int i = 0; i < n - 1; i++) {
                   if (!replaced[i] && !replaced[i + 1]
                           && s.charAt(i) == s.charAt(i + 1)) {
                       return false;
                   }
               }

               return true;
           }
       } 
    