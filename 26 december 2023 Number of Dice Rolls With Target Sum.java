class Solution {
  public int numRollsToTarget(int n, int k, int target) {
    var dp = new int[n][target];
    for (var i=0; i < Math.min(k, target); i++)
      dp[n-1][i] = 1;    
    for (var i = n-2; i >=0; i--)
      for (var j=0; j < target; j++)
        for (var x=0; x < Math.min(k, j); x++)
          dp[i][j] = (dp[i][j] + dp[i+1][j-x-1]) % 1000000007;    
    return dp[0][target-1];
  }
}
