class Solution {
    public int maxDiffSubArrays(int[] arr) {
        // code here
        int n=arr.length;
        int leftmax[]=new int[n];
        int leftmin[]=new int[n];
        int rightmax[]=new int[n];
        int rightmin[]=new int[n];
        
        // for leftmax
        int curr=arr[0];
        leftmax[0]=arr[0];
        for(int i=1;i<n;i++){
            curr=Math.max(arr[i],curr+arr[i]);
            leftmax[i]=Math.max(leftmax[i-1],curr);
        }
        // for rightmax 
        curr=arr[n-1];
        rightmax[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            curr=Math.max(arr[i],curr+arr[i]);
            rightmax[i]=Math.max(rightmax[i+1],curr);
        }
         // for leftmin
        curr=arr[0];
        leftmin[0]=arr[0];
        for(int i=1;i<n;i++){
            curr=Math.min(arr[i],curr+arr[i]);
            leftmin[i]=Math.min(leftmin[i-1],curr);
        }
        // for rightmin
        curr=arr[n-1];
        rightmin[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            curr=Math.min(arr[i],curr+arr[i]);
            rightmin[i]=Math.min(rightmin[i+1],curr);
        }
        int res=0;
        for (int i=0;i<n-1;i++) {
            res=Math.max(res,Math.abs(leftmax[i]-rightmin[i+1]));
            res=Math.max(res,Math.abs(leftmin[i]-rightmax[i+1]));
        }
        return res;
    }
}