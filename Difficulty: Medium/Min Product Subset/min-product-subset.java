class Solution {
    public int minProd(int[] arr) {
        // code here
        int n=arr.length;
        int prod=1;
        
        int negcount=0;
        int zerocount=0;
    
        int maxneg=Integer.MIN_VALUE;
        
        for(int x:arr){
            if(x<0){
                negcount++;
                 prod*=x;
                maxneg=Math.max(maxneg,x);
               
            }
        
        else if(x==0){
            zerocount++;
        }
        else{
           prod*=x;
        }
        }
        //NO NEGTAIVE NUMBERs
        if(negcount==0){
            if(zerocount>0)
                return 0;
               int minpos=Integer.MAX_VALUE;
               for(int x:arr){
                   if(x>0)
                   minpos=Math.min(minpos,x);
               }
               return minpos;
            
        }
        //odd no of negatives
        //prod of all ele igves the min negative product valuue
        
        if(negcount%2==1){
            return prod;
        }
        // Even number of negatives:
        // Remove the negative closest to zero
        prod/=maxneg;
         // If zero exists, minimum is still the negative product
        return prod;
    }
}