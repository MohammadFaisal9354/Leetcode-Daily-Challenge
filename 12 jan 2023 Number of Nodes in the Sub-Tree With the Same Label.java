class Solution 
{
    List<Integer>[] canVisit;
    public int[] countSubTrees(int n, int[][] edges, String labels) 
    {
        canVisit = new ArrayList[n];
        for(int i=0; i<n; i++)
            canVisit[i] = new ArrayList<>();
        for(int[] edge : edges)
        {
            canVisit[edge[0]].add(edge[1]);
            canVisit[edge[1]].add(edge[0]); 
        }
        boolean[] visited = new boolean[n];
        int[] answer = new int[n];
        helper(0,labels.toCharArray(),answer,visited);
        return answer;
    }
    Map<Character,Integer> helper(int node, char[] labels, int[] answer, boolean[] visited)
    {
        Map<Character,Integer> currMap = new HashMap<>();
        visited[node] = true; 
        for(int i : canVisit[node])
        {
            if(visited[i]) continue;
            Map<Character,Integer> map = helper(i, labels, answer, visited);
            for (var entry : map.entrySet())             
                currMap.put(entry.getKey(), currMap.getOrDefault(entry.getKey(),0)+ + entry.getValue());
            
        }
        currMap.put(labels[node], currMap.getOrDefault(labels[node],0)+1);
        answer[node] = currMap.get(labels[node]);
        return currMap;
    }
}
