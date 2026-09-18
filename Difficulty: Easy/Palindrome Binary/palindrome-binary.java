class Solution {
    public boolean isBinaryPalindrome(int n) {
        // code here
        String s = Integer.toBinaryString(n);

                int i = 0;
                int j = s.length() - 1;

                while (i < j) {
                    if (s.charAt(i) != s.charAt(j)) {
                        return false;
                    }

                    i++;
                    j--;
                }

                return true;
    }
};