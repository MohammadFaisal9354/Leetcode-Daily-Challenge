class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length<=1) 
            return nums;       
        int end_index=nums.length-1;        
        for(int i=0;i<nums.length && i<=end_index;i++){
            if(nums[i]%2!=0){
                int temp=nums[i];
                nums[i]=nums[end_index];
                nums[end_index]=temp;
                end_index--;
                i--;
            }
        }
        return nums;
    }
}
