class Solution {
    public String findDifferentBinaryString(String[] arr) {
        StringBuilder ans = new StringBuilder();
        int n = arr.length;
        for(int i=0; i<n; i++){
            char ch = arr[i].charAt(i);
            ans.append((ch=='1')?"0":"1");
        }
        return ans.toString();
    }
}
