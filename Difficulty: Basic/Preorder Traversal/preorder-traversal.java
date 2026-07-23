/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
        
        ArrayList<Integer> ans=new ArrayList<>();
        preorder(root,ans);
        return ans;
    }
        public void preorder(Node root,ArrayList<Integer>ans){
            if(root==null){
                return;
            }
            ans.add(root.data);//visiting the root node
            preorder(root.left,ans);//left child traversal
            preorder(root.right,ans);//right child traverse
    }
}