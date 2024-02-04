class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> temp = new HashMap<>();
        for(int i=0;i<t.length();i++)
            temp.put(t.charAt(i), temp.getOrDefault(t.charAt(i),0)+1);
        int count = temp.size();
        int i=0,j=0;
        int len = Integer.MAX_VALUE;
        String ans = new String();
        while(j<s.length()){
           if(temp.containsKey(s.charAt(j))){
               temp.put(s.charAt(j), temp.get(s.charAt(j))-1);
               if(temp.get(s.charAt(j)) == 0)
                   count--;
           }            
            if(count == 0){
                int tempLen = j-i+1;
                if(tempLen<len){
                    len = tempLen;
                    ans = s.substring(i,j+1);
                }
            }
            while(count == 0){
                char ch = s.charAt(i);
                i++;
                if(temp.containsKey(ch)){
                    temp.put(ch, temp.get(ch)+1);
                    if(temp.get(ch) > 0)
                        count++;
                    else{
                        if(count == 0){
                            int tempLen = j-i+1;
                            if(tempLen<len){
                                len = tempLen;
                                ans = s.substring(i,j+1);
                            }
                        }
                    }
                }
                else{
                    if(count == 0){
                            int tempLen = j-i+1;
                            if(tempLen<len){
                                len = tempLen;
                                ans = s.substring(i,j+1);
                            }
                        }
                }
            }
            j++;
        }
        return ans;
    }
}
