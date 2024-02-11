class Solution {
	public int cherryPickup(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
        int[][][] dp = new int[m][n][n];        
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) 
					dp[i][j][k] = -1;
			}
		}
		return Math.max(0, cherryPickup(0, 0, n - 1, m, n, arr, dp));
	}

	private int cherryPickup(int r1, int c1, int c2, int row, int col, int[][] arr, int[][][] dp) {
		if (c1 < 0 || c1 >= col || c2 < 0 || c2 >= col) 
			return Integer.MIN_VALUE;
		if (r1 == row - 1) {
			if (c1 == c2)
				return arr[r1][c1];
			else
				return arr[r1][c1] + arr[r1][c2];
		}
		if (dp[r1][c1][c2] != -1)
			return dp[r1][c1][c2];
		int max = Integer.MIN_VALUE;
		for (int dc1 = -1; dc1 <= +1; dc1++) {
			for (int dc2 = -1; dc2 <= +1; dc2++) {
				int val = 0;
				if (c1 == c2)
					val = arr[r1][c1];
				else
					val = arr[r1][c1] + arr[r1][c2];
				val += cherryPickup(r1 + 1, dc1 + c1, dc2 + c2, row, col, arr, dp);
				max = Math.max(max, val);
			}
		}
		dp[r1][c1][c2] = max;
		return max;
	}
}
