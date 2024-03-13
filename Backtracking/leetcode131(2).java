class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0, new ArrayList<>());
        return result;
    }

    public void backtracking(String s, int index, ArrayList<String> list){
        if (index == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++){
            if (isPalindrome(s.substring(index, i + 1))){
                list.add(s.substring(index, i + 1));
                backtracking(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}