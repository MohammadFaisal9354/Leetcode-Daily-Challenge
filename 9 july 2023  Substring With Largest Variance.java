class Solution {
    public int largestVariance(String s) {
        int n = s.length();
        int maxVariance = 0;
        
        int[] freq = new int[26];
        
        for (int i=0; i<n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        for (int a=0; a<26; a++) {
            for (int b=0; b<26; b++) {
                if (a == b || freq[a] == 0 || freq[b] == 0) continue;

                int[] nums = new int[n];
                
                for (int i=0; i<n; i++) {
                    int c = s.charAt(i) - 'a';
                    if (c == a) 
                        nums[i] = 1;
                    else if (c == b) 
                        nums[i] = -1;
                    
                }
                maxVariance = Math.max(maxVariance, findVariance(nums));
            }
        }
        return maxVariance;
    }
    
    private int findVariance(int[] nums) {
        int n = nums.length;
        
        int[] dpForward = new int[n];
        dpForward[0] = nums[0];
        for (int i=1; i<n; i++) {
            dpForward[i] = Math.max(dpForward[i-1]+nums[i], nums[i]);
        }
        
        int curSum = 0;
        int maxVariance = 0;
        for (int i=n-1; i>=0; i--) {
            curSum = Math.max(curSum+nums[i], nums[i]);
            if (nums[i] == -1)
                maxVariance = Math.max(maxVariance, dpForward[i] + curSum - nums[i]);
        }

        return maxVariance;
    }
}
