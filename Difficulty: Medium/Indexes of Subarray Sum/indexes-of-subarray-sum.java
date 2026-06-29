
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr,int target) {
        // code here'
         ArrayList<Integer> res=new ArrayList<>();
        int start=0;
        int sum=0;
       
       
        for( int end=0;end<arr.length;end++){
            sum+=arr[end];
            while(sum>target && start<end){
                sum-=arr[start];
                start++;
                
            }
            if(sum==target){
                res.add(start+1);//as given 1 based indexing
                res.add(end+1);
                return res;
                
            }
        }
        //if no such subarray then return -1
        res.add(-1);
        return res;
    }
}
