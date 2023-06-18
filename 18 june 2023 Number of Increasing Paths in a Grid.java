class Solution {
    int[][] dp;
    int[][] directions ={{0,1},{0,-1},{1,0},{-1,0}};
    int mod = 1_000_000_007;
    int dfs(int[][] grid, int i, int j) {
        if (dp[i][j] != 0)
            return dp[i][j];
        int answer = 1;
        for (int[] d : directions) {
            int nextI = i + d[0], nextJ = j + d[1];
            if (nextI>=0 && nextI<grid.length && nextJ>=0 && nextJ<grid[0].length && grid[nextI][nextJ]<grid[i][j]) {
                answer=answer+dfs(grid,nextI,nextJ);
                answer %= mod;
            }
        }
        dp[i][j] = answer;
        return answer;
    }
    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];
        int answer=0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                answer=(answer+dfs(grid,i,j))%mod;
            }
        }
        return answer;
    }
}
