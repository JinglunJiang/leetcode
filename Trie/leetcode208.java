class Trie {

    Node root;
    public Trie() {
        root = new Node('\0');
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
        if (getLast(word) != null && getLast(word).isWord){
            return true;
        }
        return false;
    }

    public Node getLast(String word){
        Node current = root;
        for (char c : word.toCharArray()){
            if (current.children[c - 'a'] == null){
                return null;
            }
            current = current.children[c - 'a'];
        }
        return current;
    }
    
    public boolean startsWith(String prefix) {
        if (getLast(prefix) == null){
            return false;
        }
        return true;
    }
}

class Node{
    public char val;
    public Node[] children;
    public boolean isWord;

    public Node(char val){
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