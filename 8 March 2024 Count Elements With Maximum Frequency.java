class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length,totalfreq = 0,freq[] = new int[n],visisted[] = new int[n];        
        for(int i=0;i<n;i++){
            if(visisted[i] == 1)
                continue;
            int count = 1;
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]){
                    count++;
                    visisted[i] = 1;
                }
            }
            freq[i] = count;
        }         
         int max = 0;
         for(int value : freq){
             max = Math.max(max,value);
         }
         for(int value : freq){
             if(value == max){
                 totalfreq +=value;
             }
         }
        return totalfreq;
    }
}
