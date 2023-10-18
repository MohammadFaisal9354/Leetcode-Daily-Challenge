class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int res=0;
        List<Integer> adj[]=new List[n+1];
        Stack<int[]> s=new Stack<>();
        int maxtime[]=new int[n+1];
        int indegree[]=new int[n+1];
        Arrays.fill(adj, new ArrayList<Integer>());
        for(int[] r: relations) {
            indegree[r[1]]++;
            if(adj[r[0]].size()==0) adj[r[0]]=new ArrayList<Integer>();
            adj[r[0]].add(r[1]);
        }

        for(int i=1;i<=n;i++) 
            if(indegree[i]==0) 
                s.add(new int[]{0, i});

        while(!s.isEmpty()) {
            int curr[]=s.pop(), t=curr[0]+time[curr[1]-1];
            res=Math.max(t, res);
            for(int course: adj[curr[1]]) {
                maxtime[course]=Math.max(maxtime[course], t);
                if(--indegree[course] == 0) {
                    s.push(new int[]{maxtime[course], course});
                }
            }
        }
        return res;
    }
}
