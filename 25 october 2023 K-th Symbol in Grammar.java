class Solution {
    public int kthGrammar(int n, int k) {
        return n == 1 ? 0 : kthGrammar(n - 1, (k + 1) / 2) == 0 ? (k % 2 == 0 ? 1 : 0) : (k % 2 == 0 ? 0 : 1);
    }
}
