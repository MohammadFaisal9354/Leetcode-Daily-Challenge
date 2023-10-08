class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        dp[0][0] = nums1[0]*nums2[0];
        for (int i=1; i<nums2.length; i++){
            dp[0][i] = Math.max(nums1[0]*nums2[i], dp[0][i-1]);
        }
        for (int i=1; i<nums1.length; i++){
            dp[i][0] = Math.max(nums1[i]*nums2[0], dp[i-1][0]);
        }
        for (int i=1; i<nums1.length; i++){
            for (int j=1; j<nums2.length; j++){
                dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), nums1[i]*nums2[j]+Math.max(0, dp[i-1][j-1]));
            }
        }
        return dp[nums1.length-1][nums2.length-1];
    }
}
