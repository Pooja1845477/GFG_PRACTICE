class Solution {
    int floorSqrt(int n) {
        // code here
        int low=1;
        int high=n;
        int ans=0;
        while(low<=high){
           int mid=low+(high-low)/2;
           if(mid<=n/mid){
               ans=mid;
               low=mid+1;
               
           }
           else
           high=mid-1;
        }
        return ans;
    }
}