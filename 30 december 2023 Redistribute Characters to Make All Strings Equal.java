class Solution {
    public boolean makeEqual(String[] words) {
        int freq[] = new int[26];
        for(var word : words){
            for(var c : word.toCharArray()){
                freq[c-'a']++;
            }
        }
        int sz = words.length;
        for(int indx = 0; indx < 26; indx++){
            if(freq[indx] != 0 && freq[indx] % sz != 0)return false;
        }
        return true;
    }
}
