import java.util.*;

class Solution {

    static LinkedHashSet<String> set = new LinkedHashSet<>();

    static void perms(String s, String ans) {

        // Base case
        if (s.length() == 0) {
            set.add(ans);      // Duplicate permutations automatically removed
            return;
        }

        // Fix each character one by one
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            String lss= s.substring(0, i);
            String rss = s.substring(i + 1);

            String pss =lss+rss;

            perms(pss, ans + ch);
        }
    }

    public ArrayList<String> findPermutation(String s) {

        set.clear();

        perms(s, "");

        return new ArrayList<>(set);
    }
}