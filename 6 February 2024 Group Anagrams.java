class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String s = String.valueOf(temp);            
            map.putIfAbsent(s, new ArrayList<String>());
            map.get(s).add(strs[i]);
        }
        return new ArrayList<>(map.values());        
    }
}
