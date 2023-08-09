class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums); 
        int n = nums.length;
        int lo = 0, hi = nums[n - 1] - nums[0]; 
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;  
            int possiblePairs = check(nums, mid);
            if (possiblePairs >= p) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1; 
            }
        }
        return ans;
    }

    private int check(int[] nums, int n) {
        int count = 0; 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= n) {
                count++; i++;
            }
        }
        return count;
    }
}
