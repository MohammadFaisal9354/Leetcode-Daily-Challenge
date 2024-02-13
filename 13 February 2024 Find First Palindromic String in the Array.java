class Solution {
    public String firstPalindrome(String[] words) {
          for(var word : words){
            if(isPalin(word))
                return word;
        }
        return "";
    }
    private boolean isPalin(String  word){
        int left = 0, right = word.length() - 1;
        while(left <= right){
            if(word.charAt(left++) != word.charAt(right--))return false;
        }
        return true;
    }
}
