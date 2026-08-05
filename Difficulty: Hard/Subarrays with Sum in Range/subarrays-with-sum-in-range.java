class Solution {
    static  int countatmost(int[] arr, int k) {
        if(k<0)
        return 0;
        int left=0;
        int sum=0;
        int count=0;
        for(int right=0;right<arr.length;right++){
        sum+=arr[right];
        while(sum>k)
        {
            sum-=arr[left];
            left++;
        }
            count+=(right-left+1);
        }
        return count;
    }
   public int countSubarray(int[] arr,int l,int r ){
        return countatmost(arr,r)-countatmost(arr,l-1);
    }
}