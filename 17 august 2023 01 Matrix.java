import java.util.ArrayDeque;
import java.util.Queue;
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new ArrayDeque<>();
        int maxDist = m + n; 
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) 
                    queue.offer(new int[]{r, c});
                else 
                    mat[r][c] = maxDist;
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                        && mat[newRow][newCol] > mat[row][col] + 1) {
                    mat[newRow][newCol] = mat[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }
}
