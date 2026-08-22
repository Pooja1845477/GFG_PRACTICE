class Solution {
    static long nthPosition(long n) {
        // code here
        int ans=1;
        while(ans*2<=n){
            ans*=2;
        }
        return ans;
    }
}