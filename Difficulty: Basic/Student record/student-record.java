class Solution {
      public String studentRecord(String[] names, int[][] marks) {
          int maxSum = -1;
          String result = "";

          for (int i = 0; i < names.length; i++) {
              int sum = marks[i][0] + marks[i][1] + marks[i][2];

              if (sum > maxSum) {
                  maxSum = sum;
                  result = names[i];
              } else if (sum == maxSum) {
                  result += " " + names[i];
              }
          }

          int maxAvg = maxSum / 3;

          return result + " " + maxAvg;
      }
  }