class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int first=-1;
        int second=-1;
        for(int num:arr){
            if(num>first){
                second=first;
                first=num;
            }
            else if(num>second && num!=first){
                second =num;
            }
        }
        return second;
    }
}