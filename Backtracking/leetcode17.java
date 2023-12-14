class Solution {
    List<String> result = new ArrayList<>();
    Map<Character, List<Character>> map = new HashMap<>();

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
        backtracking(0, digits, new StringBuilder());
        return result;
    }

    public void backtracking(int index, String digits, StringBuilder str){
        if (index == digits.length()){
            String string = str.toString();
            result.add(string);
            return;
        }
        char current = digits.charAt(index);
        List<Character> chars = map.get(current);
        for (char c : chars){
            str.append(c);
            backtracking(index + 1, digits, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}