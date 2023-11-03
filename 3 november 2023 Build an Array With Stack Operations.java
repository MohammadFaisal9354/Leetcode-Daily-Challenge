class Solution {
    public List<String> buildArray(int[] target, int n) {
        int i = 0;
        var res = new ArrayList<String>();
        for (int j = 1; j <= target[target.length - 1]; j++) {
            res.add("Push");
            if (j != target[i]) res.add("Pop");
            else i++;
        }
        return res;
    }
}
