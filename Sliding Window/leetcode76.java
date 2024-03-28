class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int minLength = s.length() + 1;
        int i = 0;
        for (int j = 0; j < s.length(); j++){
            sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
            while (isIncluded(tMap, sMap)){
                if (j - i + 1 < minLength){
                    minLength = j - i + 1;
                    left = i;
                    right = j;
                }
                if (sMap.containsKey(s.charAt(i))){
                    sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);
                }
                i++;
            }
        }
        if (minLength == s.length() + 1){
            return "";
        }
        return s.substring(left, right + 1);
    }

    public boolean isIncluded(Map<Character, Integer> tMap, Map<Character, Integer> sMap){
        for (char c : tMap.keySet()){
            if (!sMap.containsKey(c) || sMap.get(c) < tMap.get(c)){
                return false;
            }
        }
        return true;
    }
}