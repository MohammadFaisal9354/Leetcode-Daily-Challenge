class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length,res = 0;
        int left = 0, right = n - 1;
        int mod = 1000000007;
        Arrays.sort(nums);
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res = (res + (int)Math.pow(2, right - left)) % mod;
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
