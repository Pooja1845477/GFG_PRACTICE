class Solution {

    long ans = 0;

    public int countSubstring(String s) {

        int n = s.length();
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : -1);
        }

        mergeSort(prefix, 0, n);

        return (int) ans;
    }

    void mergeSort(long[] arr, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        count(arr, l, mid, r);
        merge(arr, l, mid, r);
    }

    void count(long[] arr, int l, int mid, int r) {

        int j = mid + 1;

        for (int i = l; i <= mid; i++) {

            while (j <= r && arr[j] <= arr[i])
                j++;

            ans += (r - j + 1);
        }
    }

    void merge(long[] arr, int l, int mid, int r) {

        long[] temp = new long[r - l + 1];

        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= r)
            temp[k++] = arr[j++];

        for (i = l, k = 0; i <= r; i++, k++)
            arr[i] = temp[k];
    }
}