class Solution {
    public int zigzagSequence(int[][] mat) {
        // code here
        int n=mat.length;
        int[] dp=new int[n];
        for(int j=0;j<n;j++){
            dp[j]=mat[0][j];
        }
        for(int i=1;i<n;i++){
            int max1=-1;
            int max2=-1;
            int maxind=-1;
            for(int j=0;j<n;j++){
                if(dp[j]>max1){
                    max2=max1;
                    max1=dp[j];
                    maxind=j;
                }
                else if(dp[j]>max2){
                    max2=dp[j];
                }
            }
            int[] newDp = new int[n];

            for (int j = 0; j < n; j++) {

                // Cannot use same column
                if (j == maxind) {
                    newDp[j] = mat[i][j] + max2;
                } 
                else {
                    newDp[j] = mat[i][j] + max1;
                }
            }

            dp = newDp;
        }

        // Find maximum answer
        int ans = 0;
 for (int value : dp) {
            ans = Math.max(ans, value);
        }

        return ans;
        
    }
}