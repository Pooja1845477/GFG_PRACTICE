class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();

        // code here
        int max=arr[arr.length-1];
        ans.add(0,max);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                ans.add(0, max);   // insert at front
            }
        }
return ans;
        
    }
}
