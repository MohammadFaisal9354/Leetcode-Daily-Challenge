class Solution {
    public int minOperations(String s) {
        int c0 = 0, c1 = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) - '0' != i%2)
                c0++;
            else
                c1++;
        } 
        return Math.min(c1, c0);
    }
}
