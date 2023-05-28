class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> list=new ArrayList<>();
        list.add(0);
        Arrays.sort(cuts);
        for(int i=0;i<cuts.length;i++){
            list.add(cuts[i]);
        }
        list.add(n);
        int[][] dp=new int[list.size()+1][list.size()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(1,cuts.length,list,dp);
    
    
    }
    public int f(int i,int j,List<Integer> list,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int steps=list.get(j+1)-list.get(i-1)+f(i,k-1,list,dp)+f(k+1,j,list,dp);
            min=Math.min(min,steps);
        }
        return dp[i][j]=min;
    }
}
