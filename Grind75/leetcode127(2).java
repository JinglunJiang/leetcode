class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)){
            return 0;
        }
        queue.offer(new Node(beginWord, 1));
        while (!queue.isEmpty()){
            Node current = queue.poll();
            String word = current.word;
            int distance = current.distance;
            if (word.equals(endWord)){
                return distance;
            }
            for (int i = 0; i < word.length(); i++){
                char[] charArray = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++){
                    charArray[i] = c;
                    String newWord = new String(charArray);
                    if (set.contains(newWord)){
                        queue.offer(new Node(newWord, distance + 1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}

class Node{
    String word;
    int distance;
    Node(String word, int distance){
        this.word = word;
        this.distance = distance;
    }
}