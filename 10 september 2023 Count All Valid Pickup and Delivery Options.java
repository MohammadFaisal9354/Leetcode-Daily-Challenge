class Solution {
    public int countOrders(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        for (int i = 1; i < dp.length; i++) {
            long k = i * (i + (i - 1));
            dp[i] = (dp[i - 1] * k) % 1000000007;
        }
        return (int) dp[dp.length - 1];
    }
}
