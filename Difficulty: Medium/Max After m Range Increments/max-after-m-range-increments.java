class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        // code here
       int diff[]=new int[n+1];
        for(int i=0;i<a.length;i++){
            diff[a[i]]+=k[i];
            if(b[i]+1<n){
                diff[b[i]+1]-=k[i];
            }
        }
        int sum=0;
       int max=0;
        //converting the diff arr into actual value
        for(int i=0;i<n;i++){
            sum+=diff[i];
            max=Math.max(sum,max);
        }
        return max;
    }
}
