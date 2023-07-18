class LRUCache {

    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    Map<Integer,Node> map= new HashMap();
    int capicity;
    public LRUCache(int _capacity) {
        capicity=_capacity;
        head.next=tail;
        tail.prev=head; 
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            Node node =map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            remove(map.get(key));
        }
        if (map.size()==capicity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
     private void insert(Node node) {
        map.put(node.key,node);
        Node headNext=head.next;
        head.next=node;
        node.prev=head;
        node.next=headNext;
        headNext.prev=node;
    }

    private void remove(Node node) {
        map.remove(node.key,node);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    class Node {
        Node prev,next;
        int key,value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
