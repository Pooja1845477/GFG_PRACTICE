class Solution {
    public int maxPathSum(int[] a, int[] b) {
        // code here
        int i=0,j=0;
        int n=a.length,m=b.length;
        int suma=0,sumb=0;
        int res=0;
        while(i<n && j<m){
            if(a[i]<b[j]){
                suma+=a[i];
                i++;
            }
            else if(a[i]>b[j]){
                sumb+=b[j];
                j++;
            }
            else{
                res+=Math.max(suma,sumb)+a[i];
                suma=0;
                sumb=0;
                i++;
                j++;
            }
        }
        while(i<n)
        suma+=a[i++];
        while(j<m)
        sumb+=b[j++];
        res+=Math.max(suma,sumb);
        return res;
        
    }
}