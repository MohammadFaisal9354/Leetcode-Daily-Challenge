class Solution {
    class Pair{
        int val;
        int count;
        Pair(int x,int y){
            val=x;
            count=y;
        }
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n=vals.length;
        int res=n;
        int[] root=new int[n];
        Pair[] value=new Pair[n];
        for(int i=0;i<n;i++){
            root[i]=i;
            value[i]=new Pair(vals[i],1);
        }
        int[][] myedges=new int[n-1][3];
        for(int i=0;i<edges.length;i++){
            myedges[i]=new int[]{Math.max(vals[edges[i][0]],vals[edges[i][1]]),edges[i][0],edges[i][1]};
        }
        Arrays.sort(myedges,(x,y)->(x[0]-y[0]));
        for(int[] edge:myedges){
            int val=edge[0];
            int node1=edge[1];
            int node2=edge[2];
            int parent1=find(root,node1);
            int parent2=find(root,node2);
            int countVal=0;
            if(value[parent1].val==value[parent2].val){
                res+=value[parent1].count*value[parent2].count;
                countVal=value[parent1].count+value[parent2].count;
            }
            else if(value[parent1].val==val){
                countVal=value[parent1].count;
            }
            else{
                countVal=value[parent2].count;
            }
            root[parent2]=parent1;
            value[parent1]=new Pair(val,countVal);
        }
        return res;
    }
    public int find(int[] root,int x){
        if(root[x]==x) return x;
        root[x]=find(root,root[x]);
        return root[x];
    }
}
