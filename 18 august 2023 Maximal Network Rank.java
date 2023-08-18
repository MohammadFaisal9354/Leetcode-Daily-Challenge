class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int max = 0;
        HashMap<Integer, Set<Integer>> adj = new HashMap<>();
        for(int[] r : roads){
            int a = r[0];
            int b = r[1];
            adj.computeIfAbsent(a, k -> new HashSet<>()).add(b);
            adj.computeIfAbsent(b, k -> new HashSet<>()).add(a);
        }
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int curr = adj.getOrDefault(i,Collections.emptySet()).size() + adj.getOrDefault(j,Collections.emptySet()).size();            
                if(adj.getOrDefault(i,Collections.emptySet()).contains(j) )
                    curr--;
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}
