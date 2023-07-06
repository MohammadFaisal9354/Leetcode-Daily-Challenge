class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = -1,j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int c = 0;
        while(i < nums.length){
            if(sum >= target){
                ans = Math.min(ans,c);
                sum -= nums[j];
                j++;
                c--;
            }
            else{
                i++;
                if(i < nums.length){
                    sum+=nums[i];
                    c++;
                }
            }
        }   
        ans = ans == Integer.MAX_VALUE ? 0 : ans;
        return ans;
    }
}
