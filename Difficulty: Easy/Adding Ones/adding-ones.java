class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        // code here
        int arr[]=new int[n];
        for(int j:updates){
            arr[j-1]++;
        }
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
       ArrayList<Integer> result = new ArrayList<>();

     for (int i = 0; i < n; i++) {
        result.add(arr[i]);
              }

        return result;
    }
}