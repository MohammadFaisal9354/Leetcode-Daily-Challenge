class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(isPossible(mid,n,index,maxSum)){
                ans = Math.max(ans,mid);
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return ans;
    }
    public boolean isPossible(int mid, int n, int index , long maxSum){
        int right = n-index-1;
        int left = index;
        maxSum -= mid;
        maxSum -= findSum(mid,left);
        maxSum -= findSum(mid,right);
        return maxSum>=0;
    }
    public long findSum(int mid , int space){
        long target = mid-1;
        long sum = 0;
        if(space>=target){
            sum += (space-target);
            sum += (target*(target+1))/2;
        }
        else{
            long diff = target-space;
            sum += (target*(target+1))/2;
            sum -= ((diff)*(diff+1))/2;
        }
        return sum;
    }
}
