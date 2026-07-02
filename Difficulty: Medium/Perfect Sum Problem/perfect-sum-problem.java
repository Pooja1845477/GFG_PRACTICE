class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
    
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int x : nums) {

            for (int j = target; j >= x; j--) {
                dp[j] += dp[j - x];
            }
        }

        return dp[target];
        
    }
}