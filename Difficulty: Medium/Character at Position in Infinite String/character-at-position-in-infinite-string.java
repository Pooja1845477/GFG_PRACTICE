class Solution {
    public char posInfinite(String s, int pos) {

                      long len = s.length();
                      long p = pos;

                      long[] lengths = new long[40];

                      int step = 0;

                      // Calculate lengths of constructed strings
                      while (len < p) {
                          step++;

                          lengths[step] = len;

                          len = 2 * len + step;
                      }

                      // Traverse backwards
                      for (int i = step; i >= 1; i--) {

                          long oldLen = lengths[i];

                          // Position belongs to dollar symbols
                          if (p > oldLen && p <= oldLen + i) {
                              return '$';
                          }

                          // Position belongs to reversed string
                          else if (p > oldLen + i) {
                              p = len - p + 1;
                          }

                          len = oldLen;
                      }

                      return s.charAt((int)p - 1);
                  }
              }