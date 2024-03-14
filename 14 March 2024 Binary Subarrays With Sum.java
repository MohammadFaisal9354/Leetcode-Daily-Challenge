class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int result = 0,prefixSum = 0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for(int i=0; i<n; i++){
            prefixSum += nums[i];
            result += map.getOrDefault(prefixSum - goal, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum,0) + 1);
        }
        return result;
    }
}
