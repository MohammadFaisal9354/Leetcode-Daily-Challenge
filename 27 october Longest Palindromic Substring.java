class Solution {
    public String longestPalindrome(String s) {
        String result = s.substring(0, 1);
        String currentPalindrom;
        for (int i = 0; i < s.length(); i++) {
            currentPalindrom = getPalindrome(s, i, i);
            result = currentPalindrom.length() > result.length() ? currentPalindrom : result;
            currentPalindrom = getPalindrome(s, i, i + 1);
            result = currentPalindrom.length() > result.length() ? currentPalindrom : result;
        }
        return result;
    }

    private String getPalindrome(String s, int beginIndex, int endIndex) {
        while (beginIndex >= 0 && endIndex <= s.length() - 1 && s.charAt(beginIndex) == s.charAt(endIndex)) {
            beginIndex--;
            endIndex++;
        }
        return s.substring(beginIndex + 1, endIndex);
    }
}
