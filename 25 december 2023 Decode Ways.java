class Solution {
    public int numDecodings(String s) {
        int [] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return num(s,0,dp);
    }
    public int num(String s,int i,int []dp){
        if(i==s.length()) return 1;
        if(dp[i]!=-1)
            return dp[i];
        int sum=0;
        if(s.charAt(i)!='0'){
            int a=s.charAt(i)-'0';
            if(a>0)
              sum+=num(s,i+1,dp);
            if((i+1)<s.length()){
                a=a*10+s.charAt(i+1)-'0';
                if(a<=26)
                    sum+=num(s,i+2,dp);
            }
        }
        return dp[i]=sum;
    }
}
