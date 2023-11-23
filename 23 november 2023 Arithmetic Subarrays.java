class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int i = 0;
        List<Boolean> ans = new ArrayList<>();
        for( ; i<l.length ;i++){
            ans.add(util(nums,l[i],r[i]));
        }
        return ans;
    }
     public boolean util(int[] nums, int l, int r) {
        if(r==l)return true;
         int arr[] = new int[r-l+1];
         int j=0;
         for(int i = l ; i <= r ; i++){
             arr[j++] = nums[i];
         }
         Arrays.sort(arr);
         int diff = arr[1]-arr[0];
         for(int i = 1;i<r-l+1;i++){
             if(arr[i]!=arr[i-1]+diff) return false;
         }
         return true;
    }
}
