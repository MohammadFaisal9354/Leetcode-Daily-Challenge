class BrowserHistory {
    private final LinkedList<String> story = new LinkedList<>();
    private int index;
    private int size = 1;

    public BrowserHistory(String homepage) {
        story.add(homepage);
    }

    public void visit(String url) {
        story.add(++index, url);
        size = index + 1;
    }

    public String back(int steps) {
        index = Math.max(0, index - steps);
        return story.get(index);
    }

    public String forward(int steps) {
        index = Math.min(size - 1, index + steps);
        return story.get(index);
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
