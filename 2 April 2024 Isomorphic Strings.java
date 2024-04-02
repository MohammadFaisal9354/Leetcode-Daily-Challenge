class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapping = new int[256];
        boolean[] mapped = new boolean[256];        
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);            
            if (mapping[charS] == 0) {
                if (mapped[charT])
                    return false;
                mapping[charS] = charT;
                mapped[charT] = true;
            } else {
                if (mapping[charS] != charT)
                    return false;
            }
        }
        return true;
    }
}
