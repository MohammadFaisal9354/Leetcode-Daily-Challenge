class Solution {
    int mod = 1000000007;
    private long combination(int n, int r) {
        if (n == 0) return 1;

        long[][] pascal = new long[n+1][r+1];
        
        pascal[0][0] = 1;
        for (int i=1; i<=n; i++) {
            pascal[i][0] = 1;
            for (int j=1; j<=r; j++) {
                pascal[i][j] = (pascal[i-1][j-1] + pascal[i-1][j]) % mod;
            }
        }
        
        return pascal[n][r];
    }

    public int numOfWays(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int i: nums) l.add(i);

        long ans = (mod + totalWays(l) - 1) % mod;

        return (int) ans;
    }

    private long totalWays(List<Integer> t) {
        if (t.size() == 0) return 1;

        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();

        int head = t.get(0);

        for (int i=1; i<t.size(); i++) {
            if (t.get(i) > head) {
                r.add(t.get(i));
            } else {
                l.add(t.get(i));
            }
        }
 
        long cnt = (totalWays(l) * totalWays(r)) % mod;
        long comb = combination(t.size()-1, l.size());

        return ((comb*cnt)%mod);

    }
}
