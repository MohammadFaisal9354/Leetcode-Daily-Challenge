class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<Integer>[] adj = getAdjList(numCourses, prerequisites);

        int[] inDegree = new int[V];
        for (int node = 0; node < V; node++)
            for (int neighbour : adj[node])
                inDegree[neighbour]++;

        Queue<Integer> queue = new ArrayDeque<>();
        for (int node = 0; node < V; node++)
            if (inDegree[node] == 0)
                queue.add(node);
        int nodesFound = 0;
        
        while (!queue.isEmpty()){
            int node = queue.remove();
            nodesFound++;
            for (int neighbour : adj[node]){
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }
        return nodesFound == V;
    }

    private ArrayList<Integer>[] getAdjList(int V, int[][] edges){
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int node = 0; node < V; node++){
            adj[node] = new ArrayList<Integer>();
        }
        for (int[] edge : edges){
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }
}
