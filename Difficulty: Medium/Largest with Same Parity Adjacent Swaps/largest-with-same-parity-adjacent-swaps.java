import java.util.*;

class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        int i = 0;

        while (i < n) {
            int j = i;

            while (j + 1 < n &&
                   arr[j] % 2 == arr[j + 1] % 2) {
                j++;
            }

            Arrays.sort(arr, i, j + 1);

            int left = i;
            int right = j;

            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }

            i = j + 1;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int k = 0; k < n; k++) {
            result.add(arr[k]);
        }

        return result;
    }
}
