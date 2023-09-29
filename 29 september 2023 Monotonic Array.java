class Solution {
    public boolean isMonotonic(int[] nums) {
         if (nums.length <= 1)
            return true;        
        int A = 0;
        int B = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<=nums[i+1])
                A++;            
            if(nums[i+1]<=nums[i])
                B++;            
        }
        if(A==nums.length-1)
            return true;        
        else if(B==nums.length-1)
            return true;        
        return false; 
    }
}
