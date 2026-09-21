/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        // code here
       

                if (root1 == null && root2 == null)
                    return true;

                if (root1 == null || root2 == null)
                    return false;

                Queue<Node> q1 = new LinkedList<>();
                Queue<Node> q2 = new LinkedList<>();

                q1.add(root1);
                q2.add(root2);

                while (!q1.isEmpty() && !q2.isEmpty()) {

                    int n1 = q1.size();
                    int n2 = q2.size();

                    if (n1 != n2)
                        return false;

                    int[] a = new int[n1];
                    int[] b = new int[n2];

                    for (int i = 0; i < n1; i++) {

                        Node x = q1.poll();
                        Node y = q2.poll();

                        a[i] = x.data;
                        b[i] = y.data;

                        if (x.left != null)
                            q1.add(x.left);

                        if (x.right != null)
                            q1.add(x.right);

                        if (y.left != null)
                            q2.add(y.left);

                        if (y.right != null)
                            q2.add(y.right);
                    }

                    Arrays.sort(a);
                    Arrays.sort(b);

                    for (int i = 0; i < n1; i++) {
                        if (a[i] != b[i])
                            return false;
                    }
                }

                return q1.isEmpty() && q2.isEmpty();
            }
        }