class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int indx = 0; indx < len; indx++) {
            while (nums[indx] >= 1 && nums[indx] <= len && nums[nums[indx] - 1] != nums[indx]) {
                int temp = nums[nums[indx] - 1];
                nums[nums[indx] - 1] = nums[indx];
                nums[indx] = temp;
            }
        }
        for (int indx = 0; indx < len; indx++) {
            if (nums[indx] != indx + 1) 
                return indx + 1;
        }
        return len + 1;
    }
}
