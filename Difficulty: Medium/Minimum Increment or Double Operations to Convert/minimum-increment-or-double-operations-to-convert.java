class Solution {
    public int countMinOperations(int arr[]) {
        // code here
      int increment=0;
      int max=0;
      for(int num:arr){
          increment+=Integer.bitCount(num);
          max=Math.max(num,max);
      }
      int doubles=0;
      while(max>1){
          max/=2;
          doubles++;
      }
      return increment+doubles;
    }
}