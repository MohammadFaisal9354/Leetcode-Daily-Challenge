class Solution {
    public int knightDialer(int n) {
        int[][] moves = new int[][]{
            {4, 6},    
            {6, 8},     
            {7, 9}, 
            {4, 8},     
            {3, 9, 0},  
            {},        
            {1, 7, 0}, 
            {2, 6},    
            {1, 3},     
            {2, 4}     
        };
        
        int MOD = 1000000007;
        int[][] dp = new int[n][10];
        int count = 0;
        
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        
        for (int move = 1; move < n; move++) {
            for (int num = 0; num < 10; num++) {
                for (int next : moves[num]) {
                    dp[move][num] = (dp[move][num] + dp[move - 1][next]) % MOD;
                }
            }
        }
        
        for (int i = 0; i < 10; i++) {
            count = (count + dp[n - 1][i]) % MOD;
        }
        
        return count;
    }
}
