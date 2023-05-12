class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length+1];

        for(int i = questions.length-1;i >= 0;i--){
            int points = questions[i][0];
            int len = questions[i][1];
            dp[i] = points;

            if(i+len < questions.length){
                dp[i] += dp[i+1+len];
            }
            dp[i] = Math.max(dp[i],dp[i+1]);
        }

        return dp[0];
    }
}
