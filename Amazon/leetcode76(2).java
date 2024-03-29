class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        int minLength = s.length() + 1;
        int substring = 0;
        int matched = 0;
        for (int j = 0; j < s.length(); j++){
            if (map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0){
                    matched++;
                }
            }
            while (matched == map.size()){
                if (minLength > j - i + 1){
                    minLength = j - i + 1;
                    substring = i;
                }
                char toDelete = s.charAt(i);
                if (map.containsKey(toDelete)){
                    if (map.get(toDelete) == 0){
                        matched--;
                    }
                    map.put(toDelete, map.get(toDelete) + 1);
                }
                i++;
            }
        }
        if (minLength <= s.length()){
            return s.substring(substring, substring + minLength);
        }
        return "";
    }
}