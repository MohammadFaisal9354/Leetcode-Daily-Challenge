public class Solution {
    public int totalMoney(int n) {
        int result = 0;
        int it = n / 7;        
        for (int i = 0; i < it; i++) 
            result += 28 + (i * 7);        
        int mod = n - it * 7;
        it += 1;
        for (int i = 0; i < mod; i++) 
            result += (i + it);
        return result;
    }
}
