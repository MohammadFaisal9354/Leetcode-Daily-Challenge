class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0 || n == 0) {
            return 1.0;
        }
        double[][][] dp = new double[n][n][k + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int l = 0; l <= k; l++) {
                    dp[i][j][l] = -1.0;
                }
            }
        }
        return probabilityCalculator(n, k, row, column, 0, dp);
    }

    public double probabilityCalculator(int n, int k, int row, int column, int currentMove, double[][][] dp) {
        if (currentMove == k) {
            return 1.0;
        }
        if (dp[row][column][currentMove] != -1) {
            return dp[row][column][currentMove];
        }
        int[] xMove = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] yMove = {1, -1, 2, -2, 2, -2, 1, -1};
        double probability = 0;
        for (int i = 0; i < 8; i++) {
            int newRow = row + xMove[i];
            int newColumn = column + yMove[i];
            if (newRow >= 0 && newColumn >= 0 && newRow < n && newColumn < n) {
                probability += 0.125 * probabilityCalculator(n, k, newRow, newColumn, currentMove + 1, dp);
            }
        }
        dp[row][column][currentMove] = probability;
        return probability;
    }
}
