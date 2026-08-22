/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {

    Node findLCA(Node root, int p, int q) {
        if (root == null)
            return null;

        if (root.data == p || root.data == q)
            return root;

        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        if (left != null && right != null)
            return root;

        if (left != null)
            return left;

        return right;
    }

    // dir: 0 = left, 1 = right
    // Returns number of turns from root to target
    int countTurns(Node root, int target, int dir) {

        if (root == null)
            return -1;

        if (root.data == target)
            return 0;

        // Go left
        int left = countTurns(root.left, target, 0);

        if (left != -1) {
            if (dir != 0)
                return left + 1;
            else
                return left;
        }

        // Go right
        int right = countTurns(root.right, target, 1);

        if (right != -1) {
            if (dir != 1)
                return right + 1;
            else
                return right;
        }

        return -1;
    }

    public int numberOfTurns(Node root, int p, int q) {

        if (root == null || p == q)
            return -1;

        Node lca = findLCA(root, p, q);

        if (lca == null)
            return -1;

        // Case 1: LCA itself is p
        if (lca.data == p) {

            int left = countTurns(lca.left, q, 0);

            if (left != -1) {
                return left == 0 ? -1 : left;
            }

            int right = countTurns(lca.right, q, 1);

            if (right != -1) {
                return right == 0 ? -1 : right;
            }

            return -1;
        }

        // Case 2: LCA itself is q
        if (lca.data == q) {

            int left = countTurns(lca.left, p, 0);

            if (left != -1) {
                return left == 0 ? -1 : left;
            }

            int right = countTurns(lca.right, p, 1);

            if (right != -1) {
                return right == 0 ? -1 : right;
            }

            return -1;
        }

        // Case 3: p and q are in different subtrees
        int pLeft = countTurns(lca.left, p, 0);

        if (pLeft != -1) {
            int qRight = countTurns(lca.right, q, 1);

            if (qRight != -1) {
                // One turn occurs at LCA
                return pLeft + qRight + 1;
            }
        }

        // p is in right and q is in left
        int pRight = countTurns(lca.right, p, 1);

        if (pRight != -1) {
            int qLeft = countTurns(lca.left, q, 0);

            if (qLeft != -1) {
                // One turn occurs at LCA
                return pRight + qLeft + 1;
            }
        }

        return -1;
    }
}