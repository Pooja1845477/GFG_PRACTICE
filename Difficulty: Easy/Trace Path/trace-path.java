class Solution {
    public boolean isPossible(int n, int m, String s) {

       int row = 0, col = 0;
       int minRow = 0, maxRow = 0;
       int minCol = 0, maxCol = 0;
           for (int i = 0; i < s.length(); i++) {
               char ch = s.charAt(i);

               if (ch == 'U') {
                   row--;
               } else if (ch == 'D') {
                   row++;
               } else if (ch == 'L') {
                   col--;
               } else if (ch == 'R') {
                   col++;
               }

               if (row < minRow) {
                   minRow = row;
               }
               if (row > maxRow) {
                   maxRow = row;
               }
               if (col < minCol) {
                   minCol = col;
               }
               if (col > maxCol) {
                   maxCol = col;
               }
           }

           return (maxRow - minRow < n) &&
                  (maxCol - minCol < m);
 
    }
}