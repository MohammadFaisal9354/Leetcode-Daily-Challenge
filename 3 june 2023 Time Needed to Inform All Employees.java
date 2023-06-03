import java.util.ArrayList;
import java.util.List;

class Solution {
    public int dfs(int n, List<Pair<Integer, Integer>>[] adj, boolean[] vis, int[] informTime) {
        int ans = 0;
        for (Pair<Integer, Integer> i : adj[n]) {
            ans = Math.max(ans, informTime[n] + dfs(i.getKey(), adj, vis, informTime));
        }
        return ans;
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Pair<Integer, Integer>>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adj[manager[i]].add(new Pair<>(i, informTime[i]));
            }
        }
        boolean[] vis = new boolean[n];
        int ans = dfs(headID, adj, vis, informTime);
        return ans;
    }
}
