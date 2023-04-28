class Solution {
    String strs[];
    Set<Integer>set;
    public int numSimilarGroups(String[] strs) {
        this.strs=strs;
        int n=strs.length;
        set=new HashSet<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!set.contains(i))
            {
                count++;
                dfs(i);
            }
        }
        return count;
    }
    boolean valid(int u,int v)
    {
        int count=0;
        for(int i=0;i<strs[v].length();i++)        
            if(strs[u].charAt(i)!=strs[v].charAt(i))
             count++;        
        return count<=2;
    }
    void dfs(int u)
    {
        set.add(u);
        for(int i=0;i<strs.length;i++)
        {
            if(set.contains(i)) 
            continue;
            if(valid(u,i)) 
            dfs(i);
        }
    }
    
}
