class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        // code here
     long ans=Long.MAX_VALUE;
     //Try number of small pizzas
     for(int i=0;i<=x+l;i++){
     //try number of medium pizzas
     for(int j=0;j<=x+l;j++){
         long area=(long)i*s+(long)j*m;     
          long cost=(long)i*cs+(long)j*cm;
          if(area>=x){
              ans=Math.min(ans,cost);
              continue;
          }
          //remaining area needed
          long rem=x-area;
          //number of large pizzas required
          long k=(rem+l-1)/l;
          cost+=k*cl;
          ans=Math.min(ans,cost);
     }
     }
     return (int)ans;
}
}