class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int max3 = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < max3)
                return true;
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                max3 = stack.peek();
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
