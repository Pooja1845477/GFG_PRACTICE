import java.util.*;

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int mid = n / 2;

        int first[] = new int[mid];
        int second[] = new int[mid];

        for (int i = 0; i < mid; i++) {
            first[i] = arr[i];
            second[i] = arr[mid + i];
        }

        Arrays.sort(first);
        Arrays.sort(second);

        int j = 0;
        int count = 0;

        for (int i = 0; i < mid; i++) {
            while (j < mid && (long) first[i] >= 5L * second[j]) {
                j++;
            }

            count += j;
        }

        return count;
    }
}