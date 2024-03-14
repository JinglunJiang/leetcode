class Solution {
    public int maxLength(List<String> arr) {
        return backtracking(arr, "", 0);
    }

    public int backtracking(List<String> arr, String current, int index){
        if (!isUnique(current)){
            return 0;
        }
        int max = current.length();
        for (int i = index; i < arr.size(); i++){
            max = Math.max(max, backtracking(arr, current + arr.get(i), i + 1));
        }
        return max;
    }

    public boolean isUnique(String current){
        int[] dictionary = new int[26];
        for (char c : current.toCharArray()){
            if (dictionary[c - 'a'] != 0){
                return false;
            }
            dictionary[c - 'a']++;
        }
        return true;
    }
}