class Solution {
    public int maxVowels(String s, int k) {
        int sum = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < k)
                sum += isVowel(s.charAt(i));
            else {
                sum += isVowel(s.charAt(i));
                sum -= isVowel(s.charAt(i - k));
            }
            if (ans < sum)
                ans = sum;
            if (ans == k)
                return k;
        }
        return ans;
    }
    int isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
    }
}
