class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int i1 = 0, i2 = 0, k1 = k, k2 = k, n = answerKey.length();
        for (int j = 0; j < n; j++) {
            if (answerKey.charAt(j) == 'F')
                k1--;
            else 
                k2--;
            if (k1 < 0 && answerKey.charAt(i1++) == 'F') k1++;
            if (k2 < 0 && answerKey.charAt(i2++) == 'T') k2++;
        }        
        return Math.max(n - i1, n - i2);
    }
}
