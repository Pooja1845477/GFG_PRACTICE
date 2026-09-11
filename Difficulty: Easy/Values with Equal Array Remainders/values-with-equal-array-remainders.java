class Solution {
    public int sameMod(int[] arr) {
        // code here
        int n=arr.length;
        int gcd=0;
        for(int i=0;i<n;i++){
            int diff=Math.abs(arr[i]-arr[0]);
            gcd=findGCD(gcd,diff);
        }
        //when all elements are equal
        if(gcd==0)
        return -1;
        //count no of divisor of gcd
        int count=0;
        for(int i=1;i*i<=gcd;i++){
            if(gcd%i==0){
                count++;
                if(i!=gcd/i){
                    count++;
                }
            }
        }
        return count;
        
    }
    private int findGCD(int a, int b) {
           while (b != 0) {
               int temp = a % b;
               a = b;
               b = temp;
           }

           return a;
}
}