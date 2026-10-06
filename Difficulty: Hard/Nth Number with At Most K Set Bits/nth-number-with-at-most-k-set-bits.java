class Solution {
    long[][] C=new long[64][64];
    public long findNthNumber(int n, int k) {
        // code here
       //Building the combination C(n,r)
       for(int i=0;i<64;i++){
           C[i][0]=1;
           C[i][i]=1;
           for(int j=1;j<i;j++){
               C[i][j]=Math.min(Long.MAX_VALUE/2,C[i-1][j-1]
               +C[i-1][j]);
           }
       }
       long answer=0;
       int ones=0;
       /*
    Include 0 as the first number.
    Therefore n is used as a zero-based index.
     */
     long rank=n-1;
     //Process bits from high to low
    for(int bit=62;bit>=0;bit--){
        /*
        If current bit is 0, all remaining lower bits
         can contain at most (k - ones) set bits.
         */
         long countwithzero=count(bit,k-ones);
         if(rank>=countwithzero){
             
             //Skip all numbers having current bit =0 
             rank-=countwithzero;
             //put 1 at current bit
             answer|=(1L<<bit);
             ones++;
             //We cannot use more than k ones
             if(ones>k){
                 return -1;
             }
         }
    }
    return answer;
    
    
    }
    // Number of binary strings of length bits
        // having at most allowed set bits.
       private long count(int bits,int allowed){
           if(allowed < 0){
               return 0;
           }
           // If we can use all bits as 1,
                   // every combination is valid.
                   if (allowed >= bits) {
                       return pow2(bits);
                   }
           long result=0;
           for(int i=0;i<=allowed;i++){
               result += C[bits][i];

                           // Prevent overflow
                           if (result >= Long.MAX_VALUE / 2) {
                               return Long.MAX_VALUE / 2;
                           }
                       }
        
       return result;
}

private long pow2(int bits){
    if(bits>=63){
         return Long.MAX_VALUE / 2;
    }
     return 1L << bits;
}
}