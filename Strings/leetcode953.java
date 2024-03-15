class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++){
            if (!isValid(words[i], words[i + 1], map)){
                return false;
            }
        }
        return true;
    }

    public boolean isValid(String word1, String word2, Map<Character, Integer> map){
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++){
            char first = word1.charAt(i);
            char second = word2.charAt(i);
            if (map.get(first) < map.get(second)){
                return true;
            }
            if (map.get(first) > map.get(second)){
                return false;
            }
        }
        if (word1.length() > word2.length()){
            return false;
        }
        return true;
    }
}