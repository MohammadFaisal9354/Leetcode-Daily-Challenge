class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n=arr.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i]-difference)){
                dp[i]=dp[hm.get(arr[i]-difference)]+1;
                max=Math.max(max,dp[i]);
            }
            hm.put(arr[i],i);
        }
        return max;
    }
}
