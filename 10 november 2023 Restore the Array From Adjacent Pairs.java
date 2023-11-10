class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int c1 = 0, c2 =0;
        boolean f1 = false, f2 =false;

        for (int[] i : adjacentPairs) {
           
                List<Integer> l = adjList.getOrDefault(i[0], new ArrayList<Integer>());
                l.add(i[1]);
                adjList.put(i[0],l );
                l = adjList.getOrDefault(i[1], new ArrayList<Integer>());
                l.add(i[0]);
                adjList.put(i[1],l );
            
        }

        for (Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()) {
            if (!f1 && entry.getValue().size() == 1) {
                c1 = entry.getKey();
                f1 = true;
            }
            else if (!f2 && entry.getValue().size() == 1) {
                c2 = entry.getKey();
                f2= true;
            }
            if (f1 && f2) break;
        }

        int[] ans = new int[adjacentPairs.length +1]; 
        ans[0] = c1;
        ans[adjacentPairs.length] = c2;

        for (int i = 1 ; i < adjacentPairs.length; i++){
            List<Integer> l = adjList.get(ans[i-1]);
            if (l.size() == 1) {
                ans[i] = l.get(0);
            } else {
                if (ans[i-2] == l.get(0)) {
                    ans[i] = l.get(1);
                } else {
                    ans[i] = l.get(0);
                }
            }
        }
        return ans;

        
    }
}
