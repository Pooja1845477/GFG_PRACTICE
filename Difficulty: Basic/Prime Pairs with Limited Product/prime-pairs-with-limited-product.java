class Solution {
    public int[] primePairs(int n) {
        // Code here
       int[] temp=new int[n*n];
       int k=0;
       for(int p=2;p<=n;p++){
           if(isPrime(p)){
               for(int q=2;q<=n;q++){
                 if (isPrime(q)&&p*q<= n) {   
                   temp[k++]=p;
                   temp[k++]=q;
               }
           }
           
       }
       }
       int ans[]=new int[k];
       for(int i=0;i<k;i++){
           ans[i]=temp[i];
          
           
       }
        return ans;
    }
       boolean isPrime(int x){
       if(x<2)
       return false;
       for(int i=2;i*i<=x;i++){
          if(x%i==0)
          return false;
       }
       return true;
    }
}