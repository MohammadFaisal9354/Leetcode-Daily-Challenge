class Disjoint{
	ArrayList<Integer> parent = new ArrayList<>();
	ArrayList<Integer> rank = new ArrayList<>();

	public Disjoint(int nodes){
		for(int i=0;i<nodes;i++){
			parent.add(i);
			rank.add(0);
		}
	}

	public int findParent(int node){
		if(parent.get(node)==node)return node;

		int result = findParent(parent.get(node));
		parent.set(node,result);
		return parent.get(node);
	}

	public boolean UnionByRank(int node1, int node2){
		int node1Parent = findParent(node1);
		int node2Parent = findParent(node2);

		if(node1Parent==node2Parent)return false; 

		if(rank.get(node1Parent)>rank.get(node2Parent)){
			parent.set(node2Parent,node1Parent);
			return true; 
		}
		else if(rank.get(node2Parent)>rank.get(node1Parent)){
			parent.set(node1Parent,node2Parent);
			return true;
		}
		else{
			 parent.set(node1Parent,node2Parent);
			int updatedRank = rank.get(node1Parent);
			rank.set(node1Parent,updatedRank+1);
			return true;
		}
	}

}

class Solution {
	public int makeConnected(int n, int[][] connections) {
		 Disjoint ds = new Disjoint(n);
		int extra =0;
		for(int[] arr:connections){
			if( !ds.UnionByRank(arr[0], arr[1])){ 
				extra++;
			}
		}

		int noOfComponents = 0;

		for (int i = 0; i <n ; i++) {
			if(ds.findParent(i)==i)noOfComponents++;
		}

	return extra>=(noOfComponents-1)?(noOfComponents-1):-1;
	}
}
