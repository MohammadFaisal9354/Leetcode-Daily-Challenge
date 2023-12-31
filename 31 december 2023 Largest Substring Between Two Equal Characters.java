class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length(),max = -1;
        int arr[] = new int [26];
        for(int i = 0; i < n; i++){
            int idx = s.charAt(i) - 'a';
            if( arr[idx] > 0)
                max = Math.max(max, i - arr[idx]);
            else
                arr[idx] = i + 1;
        }
        return max;
    }
}
