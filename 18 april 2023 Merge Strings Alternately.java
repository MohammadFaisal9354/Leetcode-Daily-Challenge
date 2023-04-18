class Solution {
    public String mergeAlternately(String word1, String word2) {
      int m1=word1.length(),m2=word2.length(),i=0,j=0;
        StringBuffer sb=new StringBuffer();
        while (i < m1 || j < m2) {
            if (i < word1.length())
                sb.append(word1.charAt(i++));
            if (j < word2.length())
                sb.append(word2.charAt(j++));
        }
    return sb.toString();
    }
}
