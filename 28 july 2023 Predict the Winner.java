class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        int total = 0;
        for (int i=0; i<nums.length; i++){
            Arrays.fill(dp[i], -1);
            total += nums[i];
        }
        int p1s = dfs(nums, 0, nums.length-1, dp, true);
        return p1s >= total-p1s;
    }

    public int dfs(int[] nums, int l, int r, int[][] dp, boolean turn){
        if (l > r){
            return 0;
        }
        if (dp[l][r] != -1){
            return dp[l][r];
        }
        if (turn){
            return dp[l][r] = Math.max(nums[l]+dfs(nums, l+1, r, dp, false), nums[r]+dfs(nums, l, r-1, dp, false));
        } else {
            return dp[l][r] = Math.min(dfs(nums, l+1, r, dp, true), dfs(nums, l, r-1, dp, true));
        }
    }
}
