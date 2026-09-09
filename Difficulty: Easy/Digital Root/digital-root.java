class Solution {
    public int digitalRoot(int n) {
        // code here
        while(n>=10){
            int sum=0;
            while(n>0){
                sum+=n%10;
                n/=10;
            }
            n=sum;
        }
        return n;
    }
}/*if (n == 0)
             return 0;

         return 1 + (n - 1) % 9;*/