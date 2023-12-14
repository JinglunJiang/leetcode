class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(1, k, n, new ArrayList<>());
        return result;
    }

    public void backtracking(int start, int k, int n, List<Integer> list){
        if (k == 0 && n == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++){
            if (n - i >= 0){
                list.add(i);
                backtracking(i + 1, k - 1, n - i, list);
                list.remove(list.size() - 1);
            }
        }
    }
}