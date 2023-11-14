class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String current = queue.poll();
                if (current.equals(endWord)){
                    return level + 1;
                }
                for (String word : wordList){
                    int diff = 0;
                    for (int j = 0; j < word.length(); j++){
                        if (current.charAt(j) != word.charAt(j)){
                            diff++;
                        }
                    }
                    if (diff == 1 && !set.contains(word)){
                        queue.offer(word);
                        set.add(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}