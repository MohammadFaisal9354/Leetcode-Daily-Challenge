class Solution {
    public int numberOfWays(String corridor) {
        int sCount = 0;
        int firstS = 0;
        int lastS=  0;    
        for(char c: corridor.toCharArray()) 
            if(c == 'S') sCount++;
        if(sCount % 2 != 0) return 0;
        if(sCount <= 2) return sCount / 2;

        int mod = (int)(1e9) + 7;
        long ans = 1l;
        int scount = 0;
        int ind = corridor.indexOf('S');
        int n = corridor.lastIndexOf('S');
        while(ind < n) {
            char ch = corridor.charAt(ind);
            if(ch == 'S') scount++;
            if(scount == 2) {
                int tmp = 1;
                int j = ind + 1;
                while(j < n && corridor.charAt(j) == 'P') {
                    tmp++;
                    j++;
                }
                ans *= tmp;
                ans = ans % mod;
                ind = j;
                scount = 0;
            }
            else 
                ind++;
        }
        return (int) ans % mod;
    }
}
