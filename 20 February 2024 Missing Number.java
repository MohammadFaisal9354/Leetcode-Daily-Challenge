class Solution {
    public int missingNumber(int[] nums) {
         int totalXor = 0;
        for(var num : nums)totalXor ^= num;
        for(int num = 0; num <= nums.length; num++){
            totalXor ^= num;
        }
        return totalXor;
    }
}
