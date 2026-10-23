import java.util.*;

class Solution {

    public int pairsViolatingBST(Node root) {
        ArrayList<Integer> values = new ArrayList<>();
        inorder(root, values);

        return countViolations(values);
    }

    private void inorder(Node root, ArrayList<Integer> values) {
        if (root == null) {
            return;
        }

        inorder(root.left, values);
        values.add(root.data);
        inorder(root.right, values);
    }

    private int countViolations(ArrayList<Integer> values) {
        int n = values.size();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = values.get(i);
        }

        int[] temp = new int[n];
        long count = mergeSort(arr, temp, 0, n - 1);

        return (int) count;
    }

    private long mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        long count = mergeSort(arr, temp, left, mid);
        count += mergeSort(arr, temp, mid + 1, right);
        count += merge(arr, temp, left, mid, right);

        return count;
    }

    private long merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return count;
    }
}