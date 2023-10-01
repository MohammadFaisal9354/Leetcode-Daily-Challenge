class Solution {
    public String reverseWords(String s) {
      char[] chars = s.toCharArray();
        int start = 0;
        int end;
        for (end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] == ' ') {
                rev(chars, start, end - 1);
                start = end + 1;
            }
        }
           return new String(chars);
        
    }
    public void rev(char[] s,int start , int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
