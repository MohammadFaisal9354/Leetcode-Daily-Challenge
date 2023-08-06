class Solution {
    int mod = 1000000007;
    public int numMusicPlaylists(int n, int goal, int k) {
        Map<String, Integer> memo = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();
        return recur(n, goal, k, lastIndex, 0, memo);
    }

    private int recur(int numOfSongs, int goal, int k, Map<Integer, Integer> lastIndex, int index,
        Map<String, Integer> memo) {

        if (index == goal) {

            if (lastIndex.size() == numOfSongs) {
                return 1;
            }
            return 0;
        }
        String key = lastIndex.size()+ "|" + index;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int ans = 0;

        for (int i = 1; i <= numOfSongs; i++) {
            Integer prevIndex = lastIndex.get(i);

            if (prevIndex != null) {

                if (index - prevIndex - 1 >= k) {
                    lastIndex.put(i, index);
                    ans = (ans + recur(numOfSongs, goal, k, lastIndex, index + 1, memo)) % mod;
                    lastIndex.put(i, prevIndex);
                }
            } else {
                lastIndex.put(i, index);
                ans = (ans + recur(numOfSongs, goal, k, lastIndex, index + 1, memo)) % mod;
                lastIndex.remove(i);
            }
        }
        memo.put(key, ans);
        return ans;
    }
}
