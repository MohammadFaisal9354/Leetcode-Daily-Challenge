class Pair{
    int src;
    int dest;
    int cost;
    Pair(int src,int dest,int cost){
        this.src=src;
        this.dest=dest;
        this.cost=cost;
    }
        @Override
	public String toString() {
		return "Pair [src=" + src + ", dest=" + dest + ", cost=" + cost + "]";
	}
}
class PairCompare implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if(p1.cost>p2.cost){
            return 1;
        }else if(p1.cost<p2.cost){
            return -1;
        }else{
            return 0;
        }
    }
}

public class Solution {    
    int[] parent;
    int[] rank;    
    private int findParent(int node){
        if(parent[node]==node){
            return node;
        }        
        return parent[node]=findParent(parent[node]);
    }
    
    private void union(int node1,int node2){
        int p1=findParent(node1);
        int p2=findParent(node2);
        if(p1 != p2){
            if(rank[p1] > rank[p2]){
                parent[p2]=p1;
            }else if(rank[p1] < rank[p2]){
                parent[p1]=p2;
            }else{
                parent[p2]=p1;
                rank[p1]=rank[p1]+1;
            }
        }
    }   
    
    public int minCostConnectPoints(int[][] points) {
        List<Pair> edges=new ArrayList();        
        int totalPoints=points.length;
        parent=new int[totalPoints];
        for(int i=0;i<totalPoints;i++){
            parent[i]=i;
        }
        rank=new int[totalPoints];        
        for(int src_point=0;src_point<totalPoints;src_point++){
            
            for(int dest_point=src_point+1;dest_point<totalPoints;dest_point++)
            {
                int distance=Math.abs(points[src_point][0] - points[dest_point][0] ) + 
                    Math.abs(points[src_point][1] - points[dest_point][1] );
                
                edges.add(new Pair(src_point,dest_point,distance));
            }
        }
        Collections.sort(edges,new PairCompare());
        int finalCost=0;
        
        for(int i=0;i<edges.size();i++){
            Pair curr_p=edges.get(i);
            int src=curr_p.src;
            int dest=curr_p.dest;
            int cost=curr_p.cost;
            
            if(findParent(src)!=findParent(dest)){
                union(src,dest);
                finalCost+=cost;
            }            
        }      
        return finalCost;
    }
}
