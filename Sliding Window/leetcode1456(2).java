class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int i = 0;
        int max = 0;
        int count = 0;
        for (int j = 0; j < s.length(); j++){
            if (set.contains(s.charAt(j))){
                count++;
            }
            if (j - i + 1 > k){
                if (set.contains(s.charAt(i))){
                    count--;
                }
                i++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}