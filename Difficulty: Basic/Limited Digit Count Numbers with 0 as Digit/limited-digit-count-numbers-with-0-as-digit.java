class Solution {
    public int findCountUpto(int d) {
        // code here
        int total=0;
        for(int i=1;i<=d;i++){
            int withzeronum=9*((int)Math.pow(10,i-1)-(int)Math.pow(9,i-1));
            total+=withzeronum;
        }
        return total;
    }
}