class Solution {
    int[] paths;
    public int longestPath(int[] parent, String s) {
        paths=new int[parent.length]; 
        ArrayList<Integer>[] a = new ArrayList[parent.length];
                for(int i=0;i<parent.length;i++)
            a[i] = new ArrayList<Integer>();
        for(int i=1;i<parent.length;i++)
            a[parent[i]].add(i);        
        dfs(-1,0,a,s);        
        int max=0;
        for(int x:paths){
            if(x>max)
            max=x;
        }
        return max+1; 
    }

    private int dfs(int prev,int curr,ArrayList<Integer>[] a,String s)
    {        
        int[] pathlength=new int[Math.max(a[curr].size(),1)]; 
        int i=0;  
        for(int x:a[curr]){
            if(x!=prev)
            {
                pathlength[i]=dfs(curr,x,a,s);
                if(s.charAt(x)!=s.charAt(curr)) 
                   pathlength[i++]++;
                else
                   pathlength[i++]=0;
            }
        }
        Arrays.sort(pathlength);
        if(pathlength.length==1)
           paths[curr]=pathlength[0];
        else if(pathlength.length>=2)
           paths[curr]=pathlength[pathlength.length-1]+pathlength[pathlength.length-2];
        return pathlength[pathlength.length-1];  
    }
}
