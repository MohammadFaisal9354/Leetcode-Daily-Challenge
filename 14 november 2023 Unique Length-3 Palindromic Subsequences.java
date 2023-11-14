class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] alphaCountToLeft = new int[n][26];
        int[] currCount = new int[26];
        for(int i = 0; i<n ; i++){
            char ch = s.charAt(i);
            copy(currCount,alphaCountToLeft,i);
            currCount[ch-'a']++;
        }
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first,n+1);
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            first[ch-'a'] = Math.min(first[ch-'a'],i);
            last[ch-'a'] = i;
        }
        int ans = 0;
        for(int i = 0; i<26; i++){
            if(first[i]!=n+1){
                ans += count(alphaCountToLeft, first[i], last[i], i);
            }
        }
        return ans;
    }
    int count(int[][] alphaCountToLeft, int first, int last, int ind){
        int count = 0;
        for(int i = 0; i<26; i++){
            if(i!=ind && alphaCountToLeft[last][i]-alphaCountToLeft[first][i]>0) count++;
        }
        if(alphaCountToLeft[last][ind]-alphaCountToLeft[first][ind]>1) count++;
        return count;
    }
    void copy(int[] currCount, int[][] alphaCountToLeft, int ind){
        for(int i = 0; i<26; i++){
            alphaCountToLeft[ind][i] = currCount[i];
        }
        return;
    }
}
