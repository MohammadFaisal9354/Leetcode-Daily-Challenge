class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length, sum = 0;
        for (int rod : rods) sum += rod;
        int[][] dp = new int[n + 1][sum + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j + rods[i - 1] <= sum && dp[i - 1][j + rods[i - 1]] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + rods[i - 1]] + rods[i - 1]);
                } 
                if (dp[i - 1][Math.abs(j - rods[i - 1])] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][Math.abs(j - rods[i - 1])] + Math.max(0, rods[i - 1] - j));
                }               
            }
        }
        return dp[n][0];
    }
}
