class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node('0');
    }
    
    public void addWord(String word) {
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
        return searchHelper(word, root, 0);
    }

    public boolean searchHelper(String word, Node root, int index){
        Node current = root;
        for (int i = index; i < word.length(); i++){
            char c = word.charAt(i);
            if (word.charAt(i) == '.'){
                for (Node child : current.children){
                    if (child != null && searchHelper(word, child, i + 1)){
                        return true;
                    }
                }
                return false;
            }
            else if (current.children[c - 'a'] == null){
                return false;
            }
            current = current.children[c - 'a'];
        }
        return current.isWord;
    }
}

class Node{
    public char val;
    public Node[] children;
    public boolean isWord;

    public Node(char val){
        this.val = val;
        this.children = new Node[26];
        this.isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */