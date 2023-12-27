class Solution {
    public int minCost(String colors, int[] neededTime) {
        int max=0,res=0,n=neededTime.length;
        for(int i=0;i<n;i++){
            if(i>0 && colors.charAt(i)==colors.charAt(i-1)){
                res+=Math.min(max,neededTime[i]);
                max=Math.max(max,neededTime[i]);
            }
            else max=neededTime[i];            
        }
        return res;
    }
}
