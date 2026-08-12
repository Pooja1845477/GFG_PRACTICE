class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        // Code here
        int n=grid.length;
        int MOD=1000000007;
        
        long paths[][]=new long[n][n];
        int [][] adventure=new int[n][n];
        paths[0][0]=1;
        adventure[0][0]=grid[0][0];
        
        //traverse through the matrix 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               if(i==0 && j==0){
               continue;
               }
               //coming from the top
               if(i>0 && (grid[i-1][j]==2 || grid[i-1][j]==3) && paths[i-1][j]>0){
                   paths[i][j]=(paths[i][j]+paths[i-1][j])%MOD;
                   adventure[i][j]=Math.max(adventure[i][j],adventure[i-1][j]+grid[i][j]);
                   
               }
               //Coming from the left 
               if(j>0 && (grid[i][j-1]==1 || grid[i][j-1]==3) && paths[i][j-1]>0){
                   paths[i][j]=(paths[i][j]+paths[i][j-1])%MOD;
                 adventure[i][j]=Math.max(adventure[i][j],adventure[i][j-1]+grid[i][j]);
               }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
           ans.add((int) paths[n-1][n-1]);
            ans.add(adventure[n-1][n-1]);
            return ans;
       
    }
}