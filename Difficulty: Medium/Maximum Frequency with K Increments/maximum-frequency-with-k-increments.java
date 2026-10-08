class Solution {
    public int maxFrequency(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
         int left=0;
         int ans=1;
         int sum=0;
         for(int right=0;right<n;right++){
             sum+=arr[right];
             while((long)arr[right]*(right-left+1)-sum>k)
             {
                 sum-=arr[left];
                 left++;
                 
             }
             ans=Math.max(ans,right-left+1);
         }
         return ans;
    }
}