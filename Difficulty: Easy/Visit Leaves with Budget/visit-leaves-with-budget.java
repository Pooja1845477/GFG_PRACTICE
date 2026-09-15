/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    ArrayList<Integer> costs = new ArrayList<>();

    void findLeaves(Node root, int level) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            costs.add(level);
            return;
        }

        findLeaves(root.left, level + 1);
        findLeaves(root.right, level + 1);
    }

    public int getCount(Node root, int k) {
        costs.clear();

        findLeaves(root, 1);

        Collections.sort(costs);

        int count = 0;

        for (int cost : costs) {
            if (cost <= k) {
                k -= cost;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}