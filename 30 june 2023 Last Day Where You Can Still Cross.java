class Solution {

    int row;
    int col;
    int[][] cells;
    int[][] directions = new int[][] {
        new int[]{1, 0},
        new int[]{-1, 0},
        new int[]{0, 1},
        new int[]{0, -1}
    };
    public int latestDayToCross(int row, int col, int[][] cells) {
        this.row = row;
        this.col = col;
        this.cells = cells;
        int low = 0;
        int high = cells.length;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (canCross(middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return high;
    }

    private boolean canCross(int middle) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < middle; i++) {
            int[] cell = cells[i];
            matrix[cell[0] - 1][cell[1]  -1] = 1;
        }
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                visited[0][i] = true;
                queue.offer(new int[]{0, i});
            }
        }
        while (queue.peek() != null) {
            int[] cell = queue.poll();
            for (int[] direction : directions) {
                int[] next =  new int[] {cell[0] + direction[0], cell[1] + direction[1]};
                int x = next[0];
                int y = next[1];
                if (x < 0 || y < 0  || y >= col) {
                    continue;
                }
                if (visited[x][y]) {
                    continue;
                }
                if (matrix[x][y] == 1) {
                    continue;
                }
                if (x == row - 1) {
                    return true;
                }
                visited[x][y] = true;
                queue.offer(next);
            }
        }
        return false;
    }
}
