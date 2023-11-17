class Solution {
    public int minPairSum(int[] nums) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());        
        for(int i = 0; i< nums.length;i++)
            min.offer(nums[i]);
        
        for(int i = 0; i< nums.length ;i++)
            max.offer(nums[i]);
        
        int maxSum = 0;
        for(int i = 0; i< nums.length/2;i++){
          int currSum = min.poll() + max.poll();
          maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}
