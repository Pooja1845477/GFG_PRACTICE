class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int n=arr.length;
        int index=0;
        int levelsize=1;
        while(index<n){
             ArrayList<Integer> level = new ArrayList<>();
             int count=Math.min(levelsize,n-index);
             for(int i=0;i<count;i++){
                level.add(arr[index++]);
             }
          Collections.sort(level);
          ans.add(level);
          levelsize*=2;
        }
        return ans;
    }
}