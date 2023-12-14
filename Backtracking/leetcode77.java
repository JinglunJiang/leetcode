class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(1, n, k, new ArrayList<>());
        return result;
    }

    public void backtracking(int start, int end, int num, List<Integer> list){
        if (num == 0){
            result.add(new ArrayList<>(list)); // lists are mutable
            return;
        }
        for (int i = start; i <= end; i++){
            list.add(i);
            backtracking(i + 1, end, num - 1, list);
            list.remove(list.size() - 1); // this can change the previous list to empty list
        }
    }
}