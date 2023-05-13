class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final int mod = 1000000007;
        int[] dp = new int[high+1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++) {
            if(i-one >= 0) dp[i] = (dp[i]+dp[i-one]) % mod;
            if(i-zero >= 0) dp[i] = (dp[i]+dp[i-zero]) % mod;
        }
        int ans = 0;
        for(int i = low; i <= high; i++) ans = (ans+dp[i]) % mod;
        return ans%mod;
        
    }
}
