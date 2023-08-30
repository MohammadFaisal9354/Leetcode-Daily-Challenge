class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        for(int i = nums.length-2;i >= 0;i--){
            if(nums[i] <= nums[i+1])
                continue;
            int k = (nums[i]-1) / nums[i+1];
            ans += k;
            nums[i] /= (k+1);
        }
        return ans;
    }
}
