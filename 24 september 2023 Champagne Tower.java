class Solution {
    double dp[][];
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(query_glass > query_row)return 0;
        dp = new double[query_row+1][query_row+1];
        for(double i[] : dp)Arrays.fill(i,-1);
        dp[0][0] = poured;
        double temp = helper(query_row,query_glass);
        return (temp > 1? 1:temp);
    }
    public double helper(int r,int c){
        if(c < 0 || r < 0  || r < c)return 0.0;
        if(c == 0 && r == 0)return dp[r][c];
        if(dp[r][c] != -1)
            return dp[r][c];
        double s =  helper(r-1,c-1)-1;
        double p =  helper(r-1,c)-1;     
        s = s < 0? 0: (s)/2;
        p = p < 0? 0: (p)/2;
        dp[r][c] = (s) + (p);
        return dp[r][c] ;
    }
}
