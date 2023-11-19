class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int x = 0;
        for(Integer num : nums){
            if(map.containsKey(num)){
                continue;
            }
            map.put(num,x++);
        }        
        int count = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>nums[0]){
                count+=map.get(nums[i]);
            }
        }
        return count;
    }
}
