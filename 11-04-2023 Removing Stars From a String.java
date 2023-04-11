class Solution {
    public String removeStars(String s) {
        List<Character> res = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c != '*') {
                res.add(c);
            } else if (!res.isEmpty()) {
                res.remove(res.size() - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }
        return sb.toString();
    }
}
