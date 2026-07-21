class Solution {
    int maxProduct(int[] arr) {
        // code here
        int n=arr.length;
        int maxprod=arr[0];
        int minprod=arr[0];
        int res=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]<0){
                int temp=maxprod;
                maxprod=minprod;
                minprod=temp;
            }
            maxprod=Math.max(arr[i],maxprod*arr[i]);
            minprod=Math.min(arr[i],minprod*arr[i]);
            res=Math.max(res,maxprod);
        }
        return res;
    }
}