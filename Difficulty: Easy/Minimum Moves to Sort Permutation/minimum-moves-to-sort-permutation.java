class Solution {
     public int minMoves(int[] arr) {
         int n = arr.length;

         int[] pos = new int[n + 1];

         // Store position of each value
         for (int i = 0; i < n; i++) {
             pos[arr[i]] = i;
         }

         int maxLen = 1;
         int currLen = 1;

         // Find longest consecutive values
         // whose positions are in increasing order
         for (int x = 1; x < n; x++) {
             if (pos[x] < pos[x + 1]) {
                 currLen++;
                 maxLen = Math.max(maxLen, currLen);
             } else {
                 currLen = 1;
             }
         }

         return n - maxLen;
     }
 }