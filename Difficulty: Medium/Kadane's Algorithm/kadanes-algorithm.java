class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
       int n=arr.length;
       int currmax=arr[0];
       int maxsofar=arr[0];
       for(int i=1;i<n;i++){
           currmax=Math.max(arr[i],currmax+arr[i]);
           maxsofar=Math.max(maxsofar,currmax);
       }
       return maxsofar;
    }
}