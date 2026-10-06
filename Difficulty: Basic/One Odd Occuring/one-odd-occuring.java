class Solution {
    // Method to find the element with odd occurrence in given array
    int getOddOccurrence(int[] arr) {
        // code here
        int res=0;
        for(int i=0;i<arr.length;i++){
            res=res^arr[i];
        }
        return res;
    }
}