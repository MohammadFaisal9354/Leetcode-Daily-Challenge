class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max,(int)intCeil(sum,i+1));
        }
        return max;
    }
    public long intCeil(long a,int b) {
      if(a%b!=0) {
          return (a/b)+1;
      }
      else 
          return a/b;
    }
}
