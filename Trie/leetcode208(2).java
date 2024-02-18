class Trie {
    Node root = new Node('0');

    public Trie() {
        
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
            else{
                current = current.children[c - 'a'];
            }
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

class Node {
    public char value;
    public Node[] children;
    public boolean isWord;

    public Node(char val) {
        this.value = value;
        this.children = new Node[26];
        this.isWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */