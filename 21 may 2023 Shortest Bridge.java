class Solution {
    int[][] dir= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestBridge(int[][] grid) {                
        int n = grid.length;        
        int mark = -1;        
        boolean[][] visited=  new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();        
        for(int i = 0; i < n; i++){
            for(int j =  0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    dfs(grid, i, j, mark--, visited);
                }
                if(grid[i][j] == -1){
                    q.add(new int[]{i, j, 0});
                }
            }
        }        
        visited = new boolean[n][n];
        int minZeroes = bfs(grid, q, visited);
        return minZeroes;
    }    
	public int bfs(int[][] grid, Queue<int[]> queue, boolean[][] visited){
        int n = grid[0].length;
        int minZeroes = Integer.MAX_VALUE;        
        while(!queue.isEmpty()){            
            int[] cur = queue.poll();            
            int level = cur[2];            
            for(int[] d:dir){                
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];               
                if(x<0 || x>=n || y<0 || y>= n || grid[x][y] == -1 || visited[x][y]){
                    continue;
                }
                if(grid[x][y] == -2) {
                    minZeroes = Math.min(minZeroes, level++);
                    continue;
                }                
                visited[x][y] = true;
                queue.offer(new int[]{x, y, level + 1});
            } 
        }        
        return minZeroes;
    }   
      static void dfs(int[][] grid, int row, int col, int color,  boolean[][] visited){        
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] != 1 ) return;       
        visited[row][col] = true;
         grid[row][col] = color;        
        dfs(grid, row - 1, col, color, visited);
        dfs(grid, row + 1, col, color, visited);
        dfs(grid, row, col  + 1, color, visited);
        dfs(grid, row, col - 1, color, visited);
        return;       
    }
}
