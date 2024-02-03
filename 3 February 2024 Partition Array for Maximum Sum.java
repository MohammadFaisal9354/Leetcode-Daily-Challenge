class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;
        int []dp =new int[N];
        for(int i=0;i<N;i++)
            dp[i] = -1;        
        return partitionsum(0, N ,arr,k,dp);
    }
    int partitionsum(int ind, int N, int []arr,int k,int[]dp){
        if(ind == N)
            return 0;
        if(dp[ind] != -1)
            return dp[ind];
        int maxi = -(int)1e7;
        int len=0;
        int maxSum = -(int)1e7;
        for(int j=ind;j<Math.min(N, ind+k);j++){
            len++;
            maxi = Math.max(arr[j],maxi);
            int sum = (len*maxi) + partitionsum(j+1,N,arr,k,dp);
            maxSum = Math.max(sum,maxSum);
        }
        dp[ind] = maxSum;
        return dp[ind];
    }
}
