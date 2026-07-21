class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();

        int[] arr= new int[26];
        for (int i = 0; i < 26; i++)
            arr[i] = -1;

        int ans = -1;

        for (int i = n - 1; i >= 0; i--) {

            int ch = s.charAt(i) - 'a';
            int end = i;

            if (ch < 25 && arr[ch + 1] != -1)
                end = arr[ch + 1];

            arr[ch] = Math.max(arr[ch], end);

            if (ch == 0)
                ans = Math.max(ans, end - i);
        }

        return ans;
    }
}