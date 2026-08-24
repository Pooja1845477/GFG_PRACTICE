class Solution {
    static final long MOD=1000000007;
    public int prefixStrings(int n) {
        // code here
        long[] dp=new long[n+1];
        dp[0]=1;
        //Catalan DP
        //Cn=C0*C(n-1) + C1*C(n-2) + ... + C(n-1)*C0
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]=(dp[i]+dp[j]*dp[i-1-j])%MOD;
            }
        }
        return (int) dp[n];
    }
}