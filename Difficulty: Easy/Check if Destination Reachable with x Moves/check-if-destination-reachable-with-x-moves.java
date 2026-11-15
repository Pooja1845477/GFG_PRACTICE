class Solution {
    public boolean canReach(int a, int b, int x) {
        // code here
        long dist=Math.abs((long)a)+Math.abs((long)b);
        if(x<dist){
        return false;
        }
        return (x-dist)%2==0;
    }
}