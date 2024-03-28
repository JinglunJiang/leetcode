class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        int match = 0;
        int left = 0;
        int right = 0;
        long minLength = s.length() + 1;
        Map<Character, Integer> sMap = new HashMap<>();
        for (int j = 0; j < s.length(); j++){
            sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
            if (sMap.get(s.charAt(j)).equals(tMap.get(s.charAt(j)))){
                match++;
            }
            while (match == tMap.keySet().size()){
                if (j - i + 1 < minLength){
                    minLength = j - i + 1;
                    left = i;
                    right = j;
                }
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);
                if (tMap.get(s.charAt(i)) != null && sMap.get(s.charAt(i)) == tMap.get(s.charAt(i)) - 1){
                    match--;
                }
                i++;
            }
        }
        if (minLength == s.length() + 1){
            return "";
        }
        return s.substring(left, right + 1);
    }
}