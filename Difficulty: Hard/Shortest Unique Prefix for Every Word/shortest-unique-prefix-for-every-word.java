class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int count = 0;
    }

    public ArrayList<String> findPrefixes(String[] arr) {
        TrieNode root = new TrieNode();

        // Insert all words
        for (String word : arr) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (curr.child[idx] == null)
                    curr.child[idx] = new TrieNode();
                curr = curr.child[idx];
                curr.count++;
            }
        }

        ArrayList<String> ans = new ArrayList<>();

        // Find shortest unique prefix
        for (String word : arr) {
            TrieNode curr = root;
            String prefix = "";
            for (char ch : word.toCharArray()) {
                prefix += ch;
                curr = curr.child[ch - 'a'];
                if (curr.count == 1)
                    break;
            }
            ans.add(prefix);
        }

        return ans;
    }
}