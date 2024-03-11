class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        for (char ch : s.toCharArray()) {
            h.put(ch, h.getOrDefault(ch, 0) + 1);
        }
        String ans = "";
        for (char ch : order.toCharArray()) {
            if (h.containsKey(ch)) {
               while(h.get(ch)>0)
                {
                    ans+=ch;
                    h.put(ch, h.getOrDefault(ch, 0) - 1);
                }
            }
        }
        for (Character ch : h.keySet()) {
            if(h.get(ch)>0)
            {
                while(h.get(ch)>0)
                {
                    ans+=ch;
                    h.put(ch, h.getOrDefault(ch, 0) - 1);
                }
            }
        }
        return ans;
    }
}
