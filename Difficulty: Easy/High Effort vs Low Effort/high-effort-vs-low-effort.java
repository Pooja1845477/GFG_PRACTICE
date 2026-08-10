class Solution {
    public int maxTask(int[] h, int[] l) {

        int noTask = 0;
        int low = 0;
        int high = 0;

        for (int i = 0; i < h.length; i++) {

            int best = Math.max(noTask, Math.max(low, high));

            int newNoTask = best;
            int newLow = best + l[i];
            int newHigh = noTask + h[i];

            noTask = newNoTask;
            low = newLow;
            high = newHigh;
        }

        return Math.max(noTask, Math.max(low, high));
    }
}