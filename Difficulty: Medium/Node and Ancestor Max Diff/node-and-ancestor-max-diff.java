/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
   
        //  code here
        int ans=Integer.MIN_VALUE;
        int findmin(Node root){
            if(root==null)
            return Integer.MAX_VALUE;
            int leftmin=findmin(root.left);
            int rightmin=findmin(root.right);
            //comparing the current node with minimum descendant
            if(leftmin!=Integer.MAX_VALUE)
            ans=Math.max(ans,root.data-leftmin);
            if(rightmin!=Integer.MAX_VALUE)
            ans=Math.max(ans,root.data-rightmin);
            return Math.min(root.data,Math.min(leftmin,rightmin));
        }
        int maxDiff(Node root){
            findmin(root);
            return ans;
        
    }
}