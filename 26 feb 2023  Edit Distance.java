class Solution {
    public int min(int n ,int m ,String s1, String s2,int [][]dp)
    {
        if(n<0) return m+1;
        if(m<0) return n+1;
        if(dp[n][m]!=-1)
        return dp[n][m];

        if(s1.charAt(n)==s2.charAt(m))
            return dp[n][m]= min(n-1,m-1,s1,s2,dp);
        return dp[n][m]= 1+Math.min( min(n-1,m-1,s1,s2,dp),Math.min(min(n,m-1,s1,s2,dp),min(n-1,m,s1,s2,dp)) );
    }
    public int minDistance(String word1, String word2) {
        int n1=word1.length(),n2=word2.length();
        int dp[][]=new int[n1][n2];
        for(int i=0;i<n1;i++)
            for(int j=0;j<n2;j++)
            dp[i][j]=-1;
        return min(n1-1,n2-1,word1,word2,dp);
    }
}
