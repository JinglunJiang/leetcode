class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++){
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word2.length(); i++){
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }
        List<Integer> values = new ArrayList<>();
        for (int value1 : map1.values()){
            values.add(value1);
        }
        for (int value2 : map2.values()){
            if (!values.contains(value2)){
                return false;
            }
            else{
                int index = values.indexOf(value2);
                values.remove(index);
            }
        }
        Set<Character> set = map1.keySet();
        for (char c : map2.keySet()){
            if (!set.contains(c)){
                return false;
            }
            set.remove(c);
        }
        if (!set.isEmpty()){
            return false;
        }
        return true;
    }
}