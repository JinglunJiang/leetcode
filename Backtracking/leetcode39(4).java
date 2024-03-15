class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, 0, 0, target, new ArrayList<>());
        return result;
    }

    public void backtracking(int[] candidates, int index, int currentSum, int target, ArrayList<Integer> list){
        if (target == currentSum){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            if (candidates[i] + currentSum <= target){
                list.add(candidates[i]);
                backtracking(candidates, i, currentSum + candidates[i], target, list);
                list.remove(list.size() - 1);
            }
        }
    }
}