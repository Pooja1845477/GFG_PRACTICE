class Solution {
    public int convertFive(int n) {
        // code here
        if(n==0){
            return 5;
        }
        int res=0;
        int place=1;
        //extracting the digit
        while(n>0){
            int d=n%10;
            if(d==0){
                d=5;
                
            }
            res=res+d*place;
            place*=10;
            n/=10;
        }
        return res;
    }
}