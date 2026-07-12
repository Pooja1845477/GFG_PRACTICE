import java.util.*;

class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {

                if (ans.isEmpty() || ans.get(ans.size() - 1) != a[i])
                    ans.add(a[i]);

                i++;

            } else if (a[i] > b[j]) {

                if (ans.isEmpty() || ans.get(ans.size() - 1) != b[j])
                    ans.add(b[j]);

                j++;

            } else {

                if (ans.isEmpty() || ans.get(ans.size() - 1) != a[i])
                    ans.add(a[i]);

                i++;
                j++;
            }
        }

        while (i < a.length) {

            if (ans.isEmpty() || ans.get(ans.size() - 1) != a[i])
                ans.add(a[i]);

            i++;
        }

        while (j < b.length) {

            if (ans.isEmpty() || ans.get(ans.size() - 1) != b[j])
                ans.add(b[j]);

            j++;
        }

        return ans;
    }
}