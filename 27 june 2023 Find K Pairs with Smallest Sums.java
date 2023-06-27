class Node {
    public int x;
    public int y;
    public int sum;
    public int index = 0;
    public Node(int x, int y, int index){
        this.x = x;
        this.y = y;
        this.index = index;
        this.sum = x + y;
    }
}
class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList();
        Queue<Node> queue = new PriorityQueue<Node>((a,b)-> a.sum - b.sum);

        for(int i=0; i<Math.min(k, nums1.length); i++){
            Node node = new Node(nums1[i], nums2[0],0);
            queue.add(node);
        }

        while(k-- > 0 && queue.size() > 0){
            List<Integer> r = new ArrayList();
            Node n = queue.poll();
            r.add(n.x);
            r.add(n.y);
            result.add(r);
            if(n.index < nums2.length-1){
                Node node = new Node(n.x, nums2[n.index+1],n.index+1);
                queue.add(node);
            }
        }
        return result;
    }
}
