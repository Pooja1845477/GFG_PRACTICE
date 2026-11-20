class Solution {
    public int minFlips(String s) {
                int count1 = 0;
                int count2 = 0;

                for (int i = 0; i < s.length(); i++) {

                    // Pattern 1: 010101...
                    if (i % 2 == 0 && s.charAt(i) != '0') {
                        count1++;
                    } else if (i % 2 != 0 && s.charAt(i) != '1') {
                        count1++;
                    }

                    // Pattern 2: 101010...
                    if (i % 2 == 0 && s.charAt(i) != '1') {
                        count2++;
                    } else if (i % 2 != 0 && s.charAt(i) != '0') {
                        count2++;
                    }
                }

                return Math.min(count1, count2);
            }
        }