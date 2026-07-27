/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {

    int preIndex;
    HashMap<Integer, Integer> map;

    Node build(int[] pre, int l, int h) {

        Node root = new Node(pre[preIndex++]);

        if (l == h || preIndex >= pre.length)
            return root;

        int index = map.get(pre[preIndex]);

        if (index >= l && index <= h) {
            root.left = build(pre, index, h);
            root.right = build(pre, l + 1, index - 1);
        }

        return root;
    }

    public Node constructBinaryTree(int[] pre, int[] preMirror) {

        preIndex = 0;
        map = new HashMap<>();

        for (int i = 0; i < preMirror.length; i++) {
            map.put(preMirror[i], i);
        }

        return build(pre, 0, preMirror.length - 1);
    }
}