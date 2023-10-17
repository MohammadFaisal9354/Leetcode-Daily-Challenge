class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();        
        int[] indegree = new int[n];        
        for(int i=0; i<n; i++)
            graph.put(i, new ArrayList<>());        
        for(int i=0; i<n; i++){
            if(leftChild[i] != -1){
                graph.get(i).add(leftChild[i]);
                indegree[leftChild[i]]++;
            }            
            if(rightChild[i] != -1){
                graph.get(i).add(rightChild[i]);
                indegree[rightChild[i]]++;
            }            
            if(graph.get(i).size() > 2)
                return false;
        }        
        int components = 0;        
        for(int i: indegree){
            if(i == 0){
                components++;                
                if(components > 1)
                    return false;
            }
            if(i > 1)
                return false;
        }        
        int[] visited = new int[n];        
        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                if(isCyclic(graph, i, visited))
                    return false;
            }
        }
        return true;
    }
    
    public boolean isCyclic(HashMap<Integer, List<Integer>> graph, int src, int[] visited){
        if(visited[src] == 2)
            return true;        
        visited[src] = 2;        
        for(int i: graph.get(src)){
            if(visited[i] != 1){
                if(isCyclic(graph, i, visited))
                    return true;
            }
        }        
        visited[src] = 1;        
        return false;
    }
}
