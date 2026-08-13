class Solution {
    public String multiplyStrings(String s1, String s2) {

        // Check sign
        boolean neg1 = false;
        boolean neg2 = false;

        if (s1.charAt(0) == '-') {
            neg1 = true;
            s1 = s1.substring(1);
        }

        if (s2.charAt(0) == '-') {
            neg2 = true;
            s2 = s2.substring(1);
        }

        // Remove leading zeroes
        int i = 0;
        while (i < s1.length() - 1 && s1.charAt(i) == '0') {
            i++;
        }
        s1 = s1.substring(i);

        i = 0;
        while (i < s2.length() - 1 && s2.charAt(i) == '0') {
            i++;
        }
        s2 = s2.substring(i);

        // If either number is zero
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }

        int n = s1.length();
        int m = s2.length();

        int[] result = new int[n + m];

        // Multiply digit by digit
        for (i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j >= 0; j--) {

                int d1 = s1.charAt(i) - '0';
                int d2 = s2.charAt(j) - '0';

                int product = d1 * d2;

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = product + result[pos2];

                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        // Convert array to string
        StringBuilder ans = new StringBuilder();

        i = 0;

        // Skip leading zeroes
        while (i < result.length && result[i] == 0) {
            i++;
        }

        while (i < result.length) {
            ans.append(result[i]);
            i++;
        }

        // Apply sign
        if (neg1 != neg2) {
            ans.insert(0, '-');
        }

        return ans.toString();
    }
}