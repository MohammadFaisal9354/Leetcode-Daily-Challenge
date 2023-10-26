class Solution {
     public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        long[] dp = new long[n];
        long ans = 0;
        Arrays.fill(dp, -1);
        Arrays.sort(arr);
        int mod = (int) (1e9 + 7);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(arr[i], i);
        for (int i = 0; i < n; i++) {
            ans = ((ans % mod) + (countTreesWithRoot(i, map, dp, arr, mod) % mod)) % mod;
        }
        return (int) ans;
    }

    private long countTreesWithRoot(int i, HashMap<Integer, Integer> map, long[] dp, int[] arr, int mod) {
        if (dp[i] != -1) return dp[i];
        int node_val = arr[i];
        long ans = 1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > Math.sqrt(node_val)) break;
            if (node_val % arr[j] == 0 && map.containsKey(node_val / arr[j])) {
                long leftWays = countTreesWithRoot(j, map, dp, arr, mod);
                long rightWays = countTreesWithRoot(map.get(node_val / arr[j]), map, dp, arr, mod);
                long res = ((leftWays % mod) * (rightWays % mod)) % mod;
                res = (res % mod) * (arr[j] == node_val / arr[j] ? 1 : 2);
                ans = (ans % mod + res % mod) % mod;
            }
        }
        return dp[i] = ans % mod;
    }
}
