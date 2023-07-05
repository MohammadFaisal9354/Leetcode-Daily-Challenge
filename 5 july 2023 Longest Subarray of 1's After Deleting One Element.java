class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int z = 0, si = 0 , cur = 0, ei = nums.length-1;
        while(cur<=ei){ 
            if(nums[cur] == 0){
                z++;
            }
            while(si<=cur && z>1 ){
                if(nums[si]==0){
                    z--;
                }
                si++;
            }
            ans = Math.max(ans, cur - si);
            cur++;
        }
        return ans;
    }
}
