class Solution {
    public boolean arrayStringsAreEqual(String[] w1, String[] w2) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer(); 
        for(int i=0; i<w1.length; i++)
            s1.append(w1[i]);
        for(int i=0; i<w2.length; i++)
            s2.append(w2[i]);
        return s1.toString().equals(s2.toString());
    }
}
