class Solution {
    Map<Character, List<Character>> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return result;
        }
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        StringBuilder sb = new StringBuilder();
        backtracking(digits, sb, 0);

        return result;
    }

    public void backtracking(String digits, StringBuilder sb, int index){
        if (index == digits.length()){
            String str = sb.toString();
            result.add(str);
            return;
        }
        char current = digits.charAt(index);
        List<Character> chars = map.get(current);

        for (char c : chars){
            sb.append(c);
            backtracking(digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}