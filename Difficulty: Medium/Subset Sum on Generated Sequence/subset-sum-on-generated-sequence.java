class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        // code here
        int n=arr.length;
        
        boolean dp[]=new boolean[x+1];
        dp[0]=true;
      
        if(s<=x){
            dp[s]=true;
        }
          long sum=s;
        //for generating next sum
        for(int num:arr){
          long next=sum+num;
          
         if (next>x) {
               break;
         }
            int val=(int)next;
       
            for(int j=x;j>=val;j--){
                dp[j]=dp[j]||dp[j-val];
            }
        
        sum+=next;
        }
        return dp[x];
    }
}