class MyQueue {
    Deque<Integer> in;
    Deque<Integer> out;
    public MyQueue() {
        this.in = new LinkedList<Integer>();
        this.out = new LinkedList<Integer>();
    }    
    public void push(int x) {
        in.offerFirst(x);
    }    
    public int pop() {
        move();
        return out.pollFirst();
    }    
    public int peek() {
        move();
        return out.peekFirst();
    }    
    public boolean empty() {
        return in.size() == 0 && out.size() == 0;
    }    
    private void move() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerFirst(in.pollFirst());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
