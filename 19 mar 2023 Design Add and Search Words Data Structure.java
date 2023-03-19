class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;

    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26];
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode curr) {
        if (index == word.length()) {
            return curr.isEndOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : curr.children) {
                if (child != null && searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = curr.children[c - 'a'];
            if (child == null) {
                return false;
            }
            return searchHelper(word, index + 1, child);
        }
    }
}
