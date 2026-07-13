import java.util.Arrays;
class Solution {
    public static int largest(int[] arr) {
        // code here
        Arrays.sort(arr);
        
           return arr[arr.length-1];
        
    }
}
