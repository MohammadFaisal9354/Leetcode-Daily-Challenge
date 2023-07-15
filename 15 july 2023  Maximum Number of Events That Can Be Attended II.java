class Solution {
    int[][] dp;
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (n1,n2)->n1[0]-n2[0]);
        dp = new int[events.length][k+1];
        int maxVal = Integer.MIN_VALUE;
        maxVal = Math.max(maxVal, process(events, 0, k));
        return maxVal;
    }

    public int process(int[][] events, int index, int noConsider){
        if(index >= events.length || noConsider == 0){
            return 0;
        }
        if(dp[index][noConsider] != 0){
            return dp[index][noConsider];
        }
        int maxVal = process(events, index+1, noConsider);
        int nextIndex = index+1;
        while(nextIndex < events.length && events[nextIndex][0] <= events[index][1])          nextIndex ++;
        
        int currConsidered = process(events, nextIndex, noConsider-1) + events[index][2];
        maxVal = Math.max(maxVal, currConsidered);
        dp[index][noConsider] = maxVal;
        return maxVal;
    }
}
