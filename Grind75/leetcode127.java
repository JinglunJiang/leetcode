class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String current = queue.poll();
                if (current.equals(endWord)){
                    return level;
                }
                for (String word : wordList){
                    int diff = 0;
                    for (int j = 0; j < word.length(); j++){
                        if (word.charAt(j) != current.charAt(j)){
                            diff++;
                        }
                    }
                    if (diff == 1 && !visited.contains(word)){
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}