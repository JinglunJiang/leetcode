class Trie {
    Node root;

    public Trie() {
        root = new Node('/');
    }
    
    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()){
            if (current.children[c - 'a'] == null){
                current.children[c - 'a'] = new Node(c);
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        Node current = root;
        for (char c : word.toCharArray()){
            if (current.children[c - 'a'] == null){
                return false;
            }
            current = current.children[c - 'a'];
        }
        return current.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node current = root;
        for (char c : prefix.toCharArray()){
            if (current.children[c - 'a'] == null){
                return false;
            }
            current = current.children[c - 'a'];
        }
        return true;
    }
}

class Node{
    char val;
    boolean isWord;
    Node[] children;

    public Node (char val){
        this.val = val;
        this.isWord = false;
        this.children = new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */