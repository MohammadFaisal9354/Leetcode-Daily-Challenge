class Solution {    
    public boolean validPartition(int[] nums) {        
        int n = nums.length;
        boolean []dp = new boolean[n+1];
        dp[0] = true;
        dp[1] = false;        
        for( int i=2; i<=n; i++ ){
            if( nums[i-1]==nums[i-2] ){
                if( i>=3 && nums[i-2]==nums[i-3] ) dp[i] = dp[i-2]||dp[i-3];
                else dp[i] = dp[i-2];
            }
            else if( i>=3 && nums[i-1]==nums[i-2]+1 && nums[i-2]==nums[i-3]+1 )
                dp[i] = dp[i-3];
        }
        return dp[n];
    }
}
