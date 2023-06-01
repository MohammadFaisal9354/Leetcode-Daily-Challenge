class tuple
{
    int first,second,third;
    tuple(int first,int second,int third)
    {
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0)
        {
            return -1;
        }
        Queue<tuple> q= new LinkedList<>();
        if(grid.length==1)
        {
            return 1;
        }
        int[][] vis=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                vis[i][j]=Integer.MAX_VALUE;
            }
        }
        vis[0][0]=0;
        q.add(new tuple(0,0,0));
        int[] dr={-1,-1,-1,0,1,1,1,0};
        int[] dc={-1,0,1,1,1,0,-1,-1};
        //for traversing in all 8 direction.
        while(!q.isEmpty())
        {
            tuple it=q.peek();
            q.poll();
            int dis=it.first;
            int r=it.second;
            int c=it.third;
            for(int i=0;i<8;i++)
            {
                int newr=r+dr[i];
                int newc=c+dc[i];
                if(newr>=0 && newr<n && newc>=0 && newc<n && grid[newr][newc]==0 && dis+1<vis[newr][newc])
                {
                    vis[newr][newc]=dis+1;
                    if(newr==n-1 && newc==n-1)
                    {
                        return dis+2;
                        
                    }
                    q.add(new tuple(dis+1,newr,newc));
                }
            }
        }
        return -1;
        
        
    }
}
