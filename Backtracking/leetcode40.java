class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, List<Integer> list, int index){
        if (target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            if (i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            if (candidates[i] <= target){
                list.add(candidates[i]);
                backtracking(candidates, target - candidates[i], list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}