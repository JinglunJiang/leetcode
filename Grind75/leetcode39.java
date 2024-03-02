class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        backtracking(candidates, target, 0, 0, list);
        return result;
    }

    private void backtracking(int[] candidates, int target, int index, int sum, List<Integer> list){
        if (target == sum){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            if (sum + candidates[i] <= target){
                list.add(candidates[i]);
                backtracking(candidates, target, i, sum + candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}