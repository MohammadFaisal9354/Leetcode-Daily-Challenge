class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> hm= new HashMap<>();
        for(int i=0; i<s.length(); i++)
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
        char maxFreqChar= '-';
        int maxFreq= 0;
        for(char c: hm.keySet()){
            if(hm.get(c) > maxFreq){
                maxFreq= hm.get(c);
                maxFreqChar= c;
            }
        }
        if(maxFreq > (s.length()+1)/2)
            return "";
        char[] result= new char[s.length()];
        int index= 0;
        for(int i=0; i<maxFreq; i++){
            result[index]= maxFreqChar;
            index+=2;
        }
        hm.remove(maxFreqChar);
        for(char c: hm.keySet()){
            if(index >= s.length())
                index= 1;
            for(int i=0; i<hm.get(c); i++){
                if(index >= s.length())
                    index= 1;                
                result[index]= c;
                index+= 2;
            }
        }
        return new String(result);
    }
}
